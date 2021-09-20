package de.stckoverflw.stckutils.extension

import org.bukkit.Material

/**
 * Checks if this Material is obtainable in survival mode.
 *
 * @return true if this material is an obtainable in survival mode
 */
fun Material.isObtainableInSurvival(): Boolean {
    if (this.isLegacy) return false
    return when (this) {
        // <editor-fold defaultstate="collapsed" desc="isObtainableInSurvival">
        Material.ACACIA_WALL_SIGN,
        Material.AIR,
        Material.AXOLOTL_SPAWN_EGG,
        Material.ATTACHED_MELON_STEM,
        Material.ATTACHED_PUMPKIN_STEM,
        Material.BAMBOO_SAPLING,
        Material.BARRIER,
        Material.BEDROCK,
        Material.BEE_SPAWN_EGG,
        Material.BEETROOTS,
        Material.BIG_DRIPLEAF_STEM,
        Material.BIRCH_WALL_SIGN,
        Material.BLACK_CANDLE_CAKE,
        Material.BLACK_WALL_BANNER,
        Material.BLAZE_SPAWN_EGG,
        Material.BLUE_CANDLE_CAKE,
        Material.BLUE_WALL_BANNER,
        Material.BRAIN_CORAL_WALL_FAN,
        Material.BROWN_CANDLE_CAKE,
        Material.BROWN_WALL_BANNER,
        Material.BUBBLE_COLUMN,
        Material.BUBBLE_CORAL_WALL_FAN,
        Material.BUNDLE,
        Material.CANDLE_CAKE,
        Material.CARROTS,
        Material.CAT_SPAWN_EGG,
        Material.CAVE_AIR,
        Material.CAVE_SPIDER_SPAWN_EGG,
        Material.CAVE_VINES,
        Material.CAVE_VINES_PLANT,
        Material.CHAIN_COMMAND_BLOCK,
        Material.CHICKEN_SPAWN_EGG,
        Material.CHORUS_PLANT,
        Material.COCOA,
        Material.COD_SPAWN_EGG,
        Material.COMMAND_BLOCK,
        Material.COMMAND_BLOCK_MINECART,
        Material.COW_SPAWN_EGG,
        Material.CREEPER_SPAWN_EGG,
        Material.CREEPER_WALL_HEAD,
        Material.CRIMSON_WALL_SIGN,
        Material.CYAN_CANDLE_CAKE,
        Material.CYAN_WALL_BANNER,
        Material.DARK_OAK_WALL_SIGN,
        Material.DEAD_BRAIN_CORAL_WALL_FAN,
        Material.DEAD_BUBBLE_CORAL_WALL_FAN,
        Material.DEAD_FIRE_CORAL_WALL_FAN,
        Material.DEAD_HORN_CORAL_WALL_FAN,
        Material.DEAD_TUBE_CORAL_WALL_FAN,
        Material.DEBUG_STICK,
        Material.DIRT_PATH,
        Material.DOLPHIN_SPAWN_EGG,
        Material.DONKEY_SPAWN_EGG,
        Material.DRAGON_WALL_HEAD,
        Material.DROWNED_SPAWN_EGG,
        Material.ELDER_GUARDIAN_SPAWN_EGG,
        Material.END_GATEWAY,
        Material.END_PORTAL,
        Material.END_PORTAL_FRAME,
        Material.ENDERMAN_SPAWN_EGG,
        Material.ENDERMITE_SPAWN_EGG,
        Material.EVOKER_SPAWN_EGG,
        Material.FARMLAND,
        Material.FIRE,
        Material.FIRE_CORAL_WALL_FAN,
        Material.FOX_SPAWN_EGG,
        Material.FROSTED_ICE,
        Material.GHAST_SPAWN_EGG,
        Material.GLOW_SQUID_SPAWN_EGG,
        Material.GOAT_SPAWN_EGG,
        Material.GRAY_CANDLE_CAKE,
        Material.GRAY_WALL_BANNER,
        Material.GREEN_CANDLE_CAKE,
        Material.GREEN_WALL_BANNER,
        Material.GUARDIAN_SPAWN_EGG,
        Material.HOGLIN_SPAWN_EGG,
        Material.HORN_CORAL_WALL_FAN,
        Material.HORSE_SPAWN_EGG,
        Material.HUSK_SPAWN_EGG,
        Material.INFESTED_CHISELED_STONE_BRICKS,
        Material.INFESTED_COBBLESTONE,
        Material.INFESTED_CRACKED_STONE_BRICKS,
        Material.INFESTED_DEEPSLATE,
        Material.INFESTED_MOSSY_STONE_BRICKS,
        Material.INFESTED_STONE,
        Material.INFESTED_STONE_BRICKS,
        Material.JIGSAW,
        Material.JUNGLE_WALL_SIGN,
        Material.KELP_PLANT,
        Material.KNOWLEDGE_BOOK,
        Material.LAVA,
        Material.LAVA_CAULDRON,
        Material.LIGHT_BLUE_CANDLE_CAKE,
        Material.LIGHT_BLUE_WALL_BANNER,
        Material.LIGHT_GRAY_CANDLE_CAKE,
        Material.LIGHT_GRAY_WALL_BANNER,
        Material.LIME_CANDLE_CAKE,
        Material.LIME_WALL_BANNER,
        Material.LLAMA_SPAWN_EGG,
        Material.MAGENTA_CANDLE_CAKE,
        Material.MAGENTA_WALL_BANNER,
        Material.MAGMA_CUBE_SPAWN_EGG,
        Material.MELON_STEM,
        Material.MOOSHROOM_SPAWN_EGG,
        Material.MOVING_PISTON,
        Material.MULE_SPAWN_EGG,
        Material.NETHER_PORTAL,
        Material.OAK_WALL_SIGN,
        Material.OCELOT_SPAWN_EGG,
        Material.ORANGE_CANDLE_CAKE,
        Material.ORANGE_WALL_BANNER,
        Material.PANDA_SPAWN_EGG,
        Material.PARROT_SPAWN_EGG,
        Material.PETRIFIED_OAK_SLAB,
        Material.PHANTOM_SPAWN_EGG,
        Material.PIGLIN_BRUTE_SPAWN_EGG,
        Material.PIGLIN_SPAWN_EGG,
        Material.PIG_SPAWN_EGG,
        Material.PILLAGER_SPAWN_EGG,
        Material.PINK_CANDLE_CAKE,
        Material.PINK_WALL_BANNER,
        Material.PISTON_HEAD,
        Material.PLAYER_HEAD,
        Material.PLAYER_WALL_HEAD,
        Material.POLAR_BEAR_SPAWN_EGG,
        Material.POTATOES,
        Material.POTTED_ACACIA_SAPLING,
        Material.POTTED_ALLIUM,
        Material.POTTED_AZALEA_BUSH,
        Material.POTTED_AZURE_BLUET,
        Material.POTTED_BAMBOO,
        Material.POTTED_BIRCH_SAPLING,
        Material.POTTED_BLUE_ORCHID,
        Material.POTTED_BROWN_MUSHROOM,
        Material.POTTED_CACTUS,
        Material.POTTED_CORNFLOWER,
        Material.POTTED_CRIMSON_FUNGUS,
        Material.POTTED_CRIMSON_ROOTS,
        Material.POTTED_DANDELION,
        Material.POTTED_DARK_OAK_SAPLING,
        Material.POTTED_DEAD_BUSH,
        Material.POTTED_FERN,
        Material.POTTED_FLOWERING_AZALEA_BUSH,
        Material.POTTED_JUNGLE_SAPLING,
        Material.POTTED_LILY_OF_THE_VALLEY,
        Material.POTTED_OAK_SAPLING,
        Material.POTTED_ORANGE_TULIP,
        Material.POTTED_OXEYE_DAISY,
        Material.POTTED_PINK_TULIP,
        Material.POTTED_POPPY,
        Material.POTTED_RED_MUSHROOM,
        Material.POTTED_RED_TULIP,
        Material.POTTED_SPRUCE_SAPLING,
        Material.POTTED_WARPED_FUNGUS,
        Material.POTTED_WARPED_ROOTS,
        Material.POTTED_WHITE_TULIP,
        Material.POTTED_WITHER_ROSE,
        Material.POWDER_SNOW,
        Material.POWDER_SNOW_CAULDRON,
        Material.PUFFERFISH_SPAWN_EGG,
        Material.PUMPKIN_STEM,
        Material.PURPLE_CANDLE_CAKE,
        Material.PURPLE_WALL_BANNER,
        Material.RABBIT_SPAWN_EGG,
        Material.RAVAGER_SPAWN_EGG,
        Material.REDSTONE_WALL_TORCH,
        Material.REDSTONE_WIRE,
        Material.RED_CANDLE_CAKE,
        Material.RED_WALL_BANNER,
        Material.REPEATING_COMMAND_BLOCK,
        Material.SALMON_SPAWN_EGG,
        Material.SCULK_SENSOR,
        Material.SHEEP_SPAWN_EGG,
        Material.SHULKER_SPAWN_EGG,
        Material.SILVERFISH_SPAWN_EGG,
        Material.SKELETON_HORSE_SPAWN_EGG,
        Material.SKELETON_SPAWN_EGG,
        Material.SKELETON_WALL_SKULL,
        Material.SLIME_SPAWN_EGG,
        Material.SOUL_FIRE,
        Material.SOUL_WALL_TORCH,
        Material.SPAWNER,
        Material.SPIDER_SPAWN_EGG,
        Material.SPORE_BLOSSOM,
        Material.SPRUCE_WALL_SIGN,
        Material.SQUID_SPAWN_EGG,
        Material.STRAY_SPAWN_EGG,
        Material.STRIDER_SPAWN_EGG,
        Material.STRUCTURE_BLOCK,
        Material.STRUCTURE_VOID,
        Material.SWEET_BERRY_BUSH,
        Material.TALL_GRASS,
        Material.TALL_SEAGRASS,
        Material.TRADER_LLAMA_SPAWN_EGG,
        Material.TRIPWIRE,
        Material.TROPICAL_FISH_SPAWN_EGG,
        Material.TUBE_CORAL_WALL_FAN,
        Material.TURTLE_SPAWN_EGG,
        Material.TWISTING_VINES_PLANT,
        Material.VEX_SPAWN_EGG,
        Material.VILLAGER_SPAWN_EGG,
        Material.VINDICATOR_SPAWN_EGG,
        Material.VOID_AIR,
        Material.WALL_TORCH,
        Material.WANDERING_TRADER_SPAWN_EGG,
        Material.WARPED_WALL_SIGN,
        Material.WATER,
        Material.WATER_CAULDRON,
        Material.WEEPING_VINES_PLANT,
        Material.WHITE_CANDLE_CAKE,
        Material.WHITE_WALL_BANNER,
        Material.WITCH_SPAWN_EGG,
        Material.WITHER_SKELETON_SPAWN_EGG,
        Material.WITHER_SKELETON_WALL_SKULL,
        Material.WOLF_SPAWN_EGG,
        Material.YELLOW_CANDLE_CAKE,
        Material.YELLOW_WALL_BANNER,
        Material.ZOGLIN_SPAWN_EGG,
        Material.ZOMBIE_HORSE_SPAWN_EGG,
        Material.ZOMBIE_SPAWN_EGG,
        Material.ZOMBIE_VILLAGER_SPAWN_EGG,
        Material.ZOMBIE_WALL_HEAD,
        Material.ZOMBIFIED_PIGLIN_SPAWN_EGG -> false
        // </editor-fold>
        else -> true
    }
}
