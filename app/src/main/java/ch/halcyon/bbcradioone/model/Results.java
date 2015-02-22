package ch.halcyon.bbcradioone.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yannick on 10/02/15.
 */
public class Results {

    @SerializedName("340")
    private _340[] __340;

    public _340[] get340() {
        return __340;
    }

    public void set340(_340[] __340) {
        this.__340 = __340;
    }
}