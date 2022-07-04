package event.model;

import event.model.Event.EventBuilder;

public class Event {
	
	//All final attributes
    private final int id; 
    private final String no;// required
    private final String name; // required
    private final String decoration; // required
    private final String catering; // required
    private final String transportation; // required
    private final String sound; // required
    private final String light; // required
	
	
    private Event(EventBuilder builder) {
    	this.id = builder.id;
    	this.no = builder.no;
        this.name = builder.name;
        this.decoration = builder.decoration;
        this.catering = builder.catering;
        this.transportation = builder.transportation;
        this.sound = builder.sound;
        this.light = builder.light;
    }
    
    
    
//Constructor
    public Event(int id, String no,String name, String decoration, String catering, String transportation, String sound, String light) {
		super();
		this.id = id;
		this.no = no;
		this.name = name;
		this.decoration = decoration;
		this.catering = catering;
		this.transportation = transportation;
		this.sound = sound;
		this.light = light;
	}
    




//All getter, and NO setter to provde immutability
    public int getId() {
        return id;
    }
    
    public String getNo() {
        return no;
    }
    
    public String getName() {
        return name;
    }
    public String getDecoration() {
        return decoration;
    }
    public String getCatering() {
        return catering;
    }
    public String getTransportation() {
        return transportation;
    }
    public String getSound() {
        return sound;
    }
    public String getLight() {
        return light;
    }
 
    @Override 
    public String toString() {
        return "Event: "+this.id+", "+this.no+","+this.name+", "+this.decoration+", "+this.catering+", "+this.transportation+", "+this.sound+", "+this.light;
    }
 
    public static class EventBuilder 
    {
    	private int id;
    	private final String no;
        private final String name;
        private final String decoration;
        private final String catering;
        private final String transportation;
        private final String sound;
        private final String light;
 
        public EventBuilder(String no,String name, String decoration, String catering, String transportation, String sound, String light) {
        	this.no = no;
        	this.name = name;
            this.decoration = decoration;
            this.catering = catering;
            this.transportation = transportation;
            this.sound = sound;
            this.light = light;
        }
        public EventBuilder id(int id) {
            this.id = id;
            return this;
        }
        
        
        
        //Return the finally consrcuted Event object
        public Event build() {
            Event event =  new Event(this);
            validateEventObject(event);
            return event;
        }
        private void validateEventObject(Event event) {
            //Do some basic validations to check 
            //if event object does not break any assumption of system
        }
    }

}
