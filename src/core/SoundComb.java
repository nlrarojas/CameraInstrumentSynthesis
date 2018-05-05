package core;

public class SoundComb {
	private double note;
	private double duration;
	private double amplitud;
	
	public SoundComb(double note, double duration, double amplitud) {
		super();
		this.note = note;
		this.duration = duration;
		this.amplitud = amplitud;
	}
	
	public double getNote() {
		return note;
	}
	
	public void setNote(double note) {
		this.note = note;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getAmplitud() {
		return amplitud;
	}
	
	public void setAmplitud(double amplitud) {
		this.amplitud = amplitud;
	}
	
	@Override
	public String toString() {
		return "SoundComb [note=" + note + ", duration=" + duration + ", amplitud=" + amplitud + "]";
	}	
}
