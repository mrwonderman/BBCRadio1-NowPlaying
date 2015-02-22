
package ch.halcyon.bbcradioone.model;

import java.util.List;

public class Realtime{
   	private String artist;
   	private String brand_pid;
   	private Number end;
   	private String episode_pid;
   	private Number programme_offset;
   	private String record_id;
   	private Number seconds_ago;
   	private String segment_event_pid;
   	private Number start;
   	private String title;
   	private String type;
   	private String version_pid;

 	public String getArtist(){
		return this.artist;
	}
	public void setArtist(String artist){
		this.artist = artist;
	}
 	public String getBrand_pid(){
		return this.brand_pid;
	}
	public void setBrand_pid(String brand_pid){
		this.brand_pid = brand_pid;
	}
 	public Number getEnd(){
		return this.end;
	}
	public void setEnd(Number end){
		this.end = end;
	}
 	public String getEpisode_pid(){
		return this.episode_pid;
	}
	public void setEpisode_pid(String episode_pid){
		this.episode_pid = episode_pid;
	}
 	public Number getProgramme_offset(){
		return this.programme_offset;
	}
	public void setProgramme_offset(Number programme_offset){
		this.programme_offset = programme_offset;
	}
 	public String getRecord_id(){
		return this.record_id;
	}
	public void setRecord_id(String record_id){
		this.record_id = record_id;
	}
 	public Number getSeconds_ago(){
		return this.seconds_ago;
	}
	public void setSeconds_ago(Number seconds_ago){
		this.seconds_ago = seconds_ago;
	}
 	public String getSegment_event_pid(){
		return this.segment_event_pid;
	}
	public void setSegment_event_pid(String segment_event_pid){
		this.segment_event_pid = segment_event_pid;
	}
 	public Number getStart(){
		return this.start;
	}
	public void setStart(Number start){
		this.start = start;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
 	public String getVersion_pid(){
		return this.version_pid;
	}
	public void setVersion_pid(String version_pid){
		this.version_pid = version_pid;
	}
}
