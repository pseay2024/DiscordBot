package org.jointheleague.modules;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.javacord.api.event.message.MessageCreateEvent;

public class ScreamMessage extends CustomMessageCreateListener {

	private static final String[] COMMANDS = {"scream", "dats scawry", "dats sad", "spider", "spiders", "those them there be spids"};

	public ScreamMessage(String channelName) {
		super(channelName);
	}

	@Override
	public void handle(MessageCreateEvent event) {
		String mes = event.getMessageContent();
		boolean contains = false;
		for (int i = 0; i < COMMANDS.length; i++)
		{
			if (mes.toLowerCase().contains(COMMANDS[i])) contains = true;
		}
		if (contains == true)
		{
			Random r = new Random();
			int numberOfAs = r.nextInt(1250);
			int numberOfHs = r.nextInt(1250);
			String scream = "";
			for (int i = 0; i < numberOfAs; i++)
			{
				scream+=(r.nextInt()%2==0)? "a" : "A";
			}
			for (int i = 0; i < numberOfHs; i++)
			{
				scream+=(r.nextInt()%2==0) ? "h" : "H";
			}
			scream+="!";
			event.getChannel().sendMessage(scream);
		}
	}
	
}