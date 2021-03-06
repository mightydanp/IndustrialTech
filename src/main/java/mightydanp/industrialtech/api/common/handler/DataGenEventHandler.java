package mightydanp.industrialtech.api.common.handler;

import mightydanp.industrialtech.api.common.datagen.BlockStates;
import mightydanp.industrialtech.api.common.datagen.Language;
import mightydanp.industrialtech.api.common.libs.Ref;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * Created by MightyDanp on 10/2/2020.
 */

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = Ref.mod_id)
public class DataGenEventHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();

        if (event.includeClient())
        {
            gen.addProvider(new Language(gen));
            gen.addProvider(new BlockStates(gen, event.getExistingFileHelper()));
        }
        if (event.includeServer()){
        }
    }
}
