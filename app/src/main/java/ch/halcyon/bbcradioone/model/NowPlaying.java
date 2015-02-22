
package ch.halcyon.bbcradioone.model;

public class NowPlaying{
   	private Realtime realtime;
   	private Number requestMaxSeconds;
   	private Number requestMinSeconds;

    public NowPlaying(){

    }

 	public Realtime getRealtime(){
		return this.realtime;
	}
	public void setRealtime(Realtime realtime){
		this.realtime = realtime;
	}
 	public Number getRequestMaxSeconds(){
		return this.requestMaxSeconds;
	}
	public void setRequestMaxSeconds(Number requestMaxSeconds){
		this.requestMaxSeconds = requestMaxSeconds;
	}
 	public Number getRequestMinSeconds(){
		return this.requestMinSeconds;
	}
	public void setRequestMinSeconds(Number requestMinSeconds){
		this.requestMinSeconds = requestMinSeconds;
	}
}
