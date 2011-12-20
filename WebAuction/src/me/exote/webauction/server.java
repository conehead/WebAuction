package me.exote.webauction;

import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.ServerListener;

public class server extends ServerListener {
	 private WebAuction plugin;

	 public server(WebAuction webAuction) {
	     this.plugin = webAuction;
	 }

    @Override
    public void onPluginDisable(PluginDisableEvent event) {
    	if (WebAuction.economy != null) {
            if(!WebAuction.economy.isEnabled()) {
                //Too spammy and not really needed as it is reported by vault anyway
            	//System.out.println("[" + plugin.info.getName() + "] Payment method was disabled. No longer accepting payments.");
            }
        }
    }

    @Override
    public void onPluginEnable(PluginEnableEvent event) {
    	if (WebAuction.economy != null) {
            if(WebAuction.economy.isEnabled()) {
                System.out.println("[" + plugin.info.getName() + "] Payment method enabled: " + WebAuction.economy.getName() + ".");
            }
        }
    	if (WebAuction.permission != null) {
            if(WebAuction.permission.isEnabled()) {
                System.out.println("[" + plugin.info.getName() + "] Permission method enabled: " + WebAuction.permission.getName() + ".");
            }
        }
    }
}