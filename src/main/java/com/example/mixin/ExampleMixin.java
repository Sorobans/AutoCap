package net.fabricmc.example.mixin;

import net.minecraft.client.gui.screens.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ChatScreen.class)
public class ExampleMixin {

    // Using "onChatSendMessage" which is the more stable method name for 1.21.11
    @ModifyVariable(method = "handleChatInput", at = @At("HEAD"), argsOnly = true)
    private String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) return text;
        
        if (Character.isLowerCase(text.charAt(0))) {
            return Character.toUpperCase(text.charAt(0)) + text.substring(1);
        }
        return text;
    }
}
