package ws.discord.commands;

import net.dv8tion.jda.entities.Message;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.entities.impl.MessageImpl;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ws.discord.messages.MessageHandler;

import static org.testng.Assert.*;

public class CServersTest extends CommandTest{

    @BeforeMethod
    public void setUp() throws Exception {
        super.setUp();
        command = new CServers(jda, dao);
    }

    @Test
    public void testExecute() throws Exception {
        User user = jda.getUserById("63263941735755776");
        Message message = new MessageImpl("", null).setChannelId("131483070464393216").setAuthor(user).setContent("lol");
        MessageReceivedEvent mre = new MessageReceivedEvent(jda, 1, message);
        command.execute(mre, "");

        Assert.assertEquals(1, MessageHandler.getQueue().size());
        Assert.assertEquals(MessageHandler.getQueue().peek().getMessage().getContent(), "Server count : 1");
    }

}