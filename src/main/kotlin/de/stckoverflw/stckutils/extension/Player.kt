package de.stckoverflw.stckutils.extension

import de.stckoverflw.stckutils.StckUtilsPlugin
import de.stckoverflw.stckutils.config.Config
import de.stckoverflw.stckutils.util.Namespaces
import de.stckoverflw.stckutils.util.get
import de.stckoverflw.stckutils.util.has
import de.stckoverflw.stckutils.util.remove
import de.stckoverflw.stckutils.util.set
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.main.KSpigotMainInstance
import net.kyori.adventure.text.Component
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.util.Vector

fun Player.resetWorlds() {
    Config.resetSettingsConfig.shouldReset = true
    onlinePlayers.forEach {
        it.kick(
            successTranslatable("player.reset_worlds", name())
        )
    }
    server.spigot().restart()
}

fun Player.setSavedInventory() {
    if (persistentDataContainer.has(Namespaces.CHALLENGE_INVENTORY_CONTENTS)) {
        inventory.clear()
        inventory.setContents(
            persistentDataContainer.get(Namespaces.CHALLENGE_INVENTORY_CONTENTS)
                ?.let { fromBase64(it) }?.filterNotNull()?.toTypedArray() ?: arrayOf()
        )
        persistentDataContainer.remove(Namespaces.CHALLENGE_INVENTORY_CONTENTS)
    }
}

fun Player.saveInventory() {
    persistentDataContainer.set(
        Namespaces.CHALLENGE_INVENTORY_CONTENTS,
        toBase64(inventory.contents.filterNotNull().toTypedArray())
    )
}

var Player.hidden: Boolean
    get() = (Config.hideConfig.getSetting(this.uniqueId.toString()) ?: false) as Boolean
    set(value) = Config.hideConfig.setSetting(this.uniqueId.toString(), value)

fun Player.hide() {
    this.hidden = true

    onlinePlayers.forEach { player ->
        if (player == this) return@forEach
        if (player.hidden) {
            player.showPlayer(KSpigotMainInstance, this)
        } else {
            player.hidePlayer(KSpigotMainInstance, this)
        }
        this.showPlayer(KSpigotMainInstance, player)
    }
}

fun Player.reveal() {
    this.hidden = false

    onlinePlayers.forEach { player ->
        if (player == this) return@forEach
        if (player.hidden) {
            this.hidePlayer(KSpigotMainInstance, player)
        } else {
            this.showPlayer(KSpigotMainInstance, player)
        }
        player.showPlayer(KSpigotMainInstance, this)
    }
}

fun Player.isPlaying() = !this.hidden && this.gameMode == GameMode.SURVIVAL

fun Player.isInArea(location1: Location, radius: Double): Boolean {
    return location.toVector().isInSphere(location1.toVector(), radius)
}

fun Player.isInArea(location1: Location, location2: Location): Boolean {
    val vector1 = location1.toVector()
    val vector2 = location2.toVector()
    return location.toVector().isInAABB(Vector.getMinimum(vector1, vector2), Vector.getMaximum(vector1, vector2))
}

fun Player.sendPrefixMessage(meessage: String) = sendPrefixMessage(Component.text(meessage))

fun Player.sendPrefixMessage(message: Component) = sendMessage(
    literalText {
        component(StckUtilsPlugin.prefix)
        component(message)
    }
)
