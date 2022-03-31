import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerManager 
{
    public ArrayList<String> theMessages;

    public ServerManager()
    {
        this.theMessages = new ArrayList<String>();
    }

    public void addString(String message)
    {
        this.theMessages.add(message);
    }

    public ArrayList displayMessages()
    {
        return this.theMessages;
    }


}
