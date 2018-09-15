package li.xiangyang.android.android_webexplorer;

import java.io.Serializable;
import java.util.Map;

public class HeaderMap implements Serializable {

    private Map<String,String> map;

    public HeaderMap(Map<String, String> map) {
        this.map = map;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}