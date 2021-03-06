package mightydanp.industrialtech.api.common.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;

import java.util.List;

/**
 * Created by MightyDanp on 9/30/2020.
 */
public class OreGenFeatureConfig implements IFeatureConfig {

    public static final Codec<OreGenFeatureConfig> field_236566_a_ = RecordCodecBuilder.create((p_236568_0_) -> {
        return p_236568_0_.group(Codec.STRING.fieldOf("vein_name").forGetter(z -> {
                    return z.veinName;
                }),BlockState.CODEC.listOf().fieldOf("state").forGetter((a) -> {
                    return a.blocks;
                }), Codec.intRange(0, 100).listOf().fieldOf("ore_spawn_chance").forGetter(a -> {
                    return a.veinBlockChances;
                }), Codec.intRange(0, 64).fieldOf("size").forGetter((a) -> {
                    return a.size;
                }), Codec.intRange(0, 100).fieldOf("rarity").forGetter((a) -> {
                    return a.rarity;
                }), Codec.intRange(0, 64).fieldOf("outOf").forGetter((a) -> {
                    return a.outOf;
                })).apply(p_236568_0_, (p_i241989_1_, p_i241989_2_, p_i241989_3_, p_i241989_4_, p_i241989_5_, p_i241989_6_) -> new OreGenFeatureConfig(p_i241989_1_, p_i241989_2_, p_i241989_3_, p_i241989_4_, p_i241989_5_, p_i241989_6_));

    });
    public String veinName;
    public final int size;
    public final int rarity;
    public final int outOf;
    public List<BlockState> blocks;
    public List<Integer> veinBlockChances;


    public OreGenFeatureConfig(String VeinNameIn, List<BlockState> blockStatesIn, List<Integer> veinBlockChancesIn, int veinSizeIn, int rarityIn, int outOfIn) {
        this.veinName = VeinNameIn;
        this.size = veinSizeIn;
        this.blocks = blockStatesIn;
        this.veinBlockChances = veinBlockChancesIn;
        this.rarity = rarityIn;
        this.outOf = outOfIn;
    }

    public static final class FillerBlockType {
        public static final RuleTest field_241882_a = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
        public static final RuleTest field_241883_b = new BlockMatchRuleTest(Blocks.NETHERRACK);
        public static final RuleTest field_241884_c = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
    }
}