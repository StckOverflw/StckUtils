package de.stckoverflw.stckutils.extension

import de.stckoverflw.stckutils.StckUtilsPlugin
import de.stckoverflw.stckutils.config.Config
import de.stckoverflw.stckutils.util.*
import net.axay.kspigot.extensions.geometry.LocationArea
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.main.KSpigotMainInstance
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.JoinConfiguration
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.*

fun Player.resetWorlds() {
    Config.resetSettingsConfig.shouldReset = true
    onlinePlayers.forEach {
        it.kick(
            Component.join(
                JoinConfiguration.separator(text("\n")),
                Component.newline(),
                text(
                    StckUtilsPlugin.translationsProvider.translate(
                        "player.reset_worlds",
                        it.language,
                        "messages",
                        arrayOf(name)
                    )
                )
            )
        )
    }
    Bukkit.getServer().spigot().restart()
}

fun Player.setSavedInventory() {
    if (persistentDataContainer.has(Namespaces.CHALLENGE_INVENTORY_CONTENTS)) {
        inventory.clear()
        @Suppress("UNCHECKED_CAST")
        inventory.setContents(
            persistentDataContainer.get(Namespaces.CHALLENGE_INVENTORY_CONTENTS)
                ?.let { fromBase64(it) } as Array<out ItemStack>
        )
        persistentDataContainer.remove(Namespaces.CHALLENGE_INVENTORY_CONTENTS)
    }
}

fun Player.saveInventory() {
    @Suppress("UNCHECKED_CAST")
    persistentDataContainer.set(
        Namespaces.CHALLENGE_INVENTORY_CONTENTS,
        toBase64(inventory.contents as Array<ItemStack>)
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

fun Player.isInArea(location: Location, radius: Double): Boolean {
    val add = Location(location.world, location.x - radius, 0.0, location.z + radius)
    val sub = Location(location.world, location.x + radius, 0.0, location.z - radius)

    return LocationArea(add.toBlockLocation(), sub.toBlockLocation()).isInArea(this.location, false, 0)
}

fun Player.isInArea(location: Location, location2: Location): Boolean =
    LocationArea(location, location2).isInArea(this.location, false, 0)

var Player.language: Locale
    get() = Config.languageConfig.getLanguage(this)
    set(value) = Config.languageConfig.setLanguage(this, value)
