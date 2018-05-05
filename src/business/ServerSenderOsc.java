package business;

import core.src.main.java.com.illposed.osc.OSCMessage;
import core.src.main.java.com.illposed.osc.OSCPortOut;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ServerSenderOsc {
	private OSCPortOut oscPort;
	
	public ServerSenderOsc () {		
		addressServer();
	}
	
	public void addressServer() {
        try {
            oscPort = new OSCPortOut(InetAddress.getByName("localhost"));
        } catch (UnknownHostException | SocketException e) {
            System.err.println("Couldn't set address");
        }
    }
    
    public void doSendOn(float freq, float volumn, float intervale, int node) {
        if (null == oscPort) {
            System.err.println("Please set an address first");
        }

        // send an OSC message to start the synth "pink" on node 1000.
        List<Object> args = new ArrayList<>();
        args.add("function-1");
        args.add(node);
        args.add(1);
        args.add(0);
        args.add("freq");
        args.add(freq);
        args.add("volumn");
        args.add(volumn);
        args.add("speed");
        args.add(intervale);
        // a comma is placed after /s_new in the code
        OSCMessage msg = new OSCMessage("/s_new", args);

        // Object[] args2 = {new Symbol("amp"), new Float(0.5)};
        // OscMessage msg2 = new OscMessage("/n_set", args2);
        //oscPort.send(msg);
        // try to use the send method of oscPort using the msg in nodeWidget
        // send an error message if this doesn't happen
        try {
            oscPort.send(msg);
        } catch (Exception ex) {
            System.err.println("Couldn't send");
        }
    }

    // create a method for the doSend1 action (Send)
    public void doSendOff(int node) {
        if (null == oscPort) {
            System.err.println("Please set an address first");
        }

        List<Object> args = new ArrayList<>();
        args.add(node);
        OSCMessage msg = new OSCMessage("/n_free", args);

        try {
            oscPort.send(msg);
        } catch (Exception e) {
            System.err.println("Couldn't send");
        }
    }
    
    public void doSendSlider(double freq, double volumn, double speed, int node) {
        if (null == oscPort) {
            System.err.println("Please set an address first");
        }
        List<Object> args = new ArrayList<>();
        args.add(node);
        args.add("freq");
        args.add(freq);      
        OSCMessage msg = new OSCMessage("/n_set", args);
        try {
            oscPort.send(msg);
        } catch (Exception e) {
            System.err.println("Couldn't send");
        }          
    }
}
