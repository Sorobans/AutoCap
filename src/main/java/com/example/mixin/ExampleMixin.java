package net.fabricmc.example.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ChatScreen.class)
public class ExampleMixin {
    @ModifyVariable(method = "handleText", at = @At("HEAD"), argsOnly = true)
    private String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) return text;
        
        // The Vibe: Only capitalize if the first character is a lowercase letter
        if (Character.isLowerCase(text.charAt(0))) {
            return Character.toUpperCase(text.charAt(0)) + text.substring(1);
        }
        return text;
    }
}