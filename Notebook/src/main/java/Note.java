import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Note {
    @SerializedName("time")
    private String time;
    @SerializedName("text")
    private String text;

    Note(String date, String text) {
        this.time = date;
        this.text = text;
    }

    protected void setTime(String date) {
        this.time = date;
    }

    protected String getTime() {
        return this.time;
    }

    protected void setText(String text) {
        this.text = text;
    }

    protected String getText() {
        return this.text;
    }

}
