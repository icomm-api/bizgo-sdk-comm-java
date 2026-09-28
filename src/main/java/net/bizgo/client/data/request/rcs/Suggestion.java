package net.bizgo.client.data.request.rcs;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.bizgo.client.data.request.rcs.buttons.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Suggestion {

    private UrlAction urlAction;
    private DialerAction dialerAction;
    private ClipboardAction clipboardAction;
    private MapAction mapAction;
    private CalendarAction calendarAction;
    private ComposeAction composeAction;

    public UrlAction getUrlAction() {
        return urlAction;
    }

    public void setUrlAction(UrlAction urlAction) {
        this.urlAction = urlAction;
    }

    public DialerAction getDialerAction() {
        return dialerAction;
    }

    public void setDialerAction(DialerAction dialerAction) {
        this.dialerAction = dialerAction;
    }

    public ClipboardAction getClipboardAction() {
        return clipboardAction;
    }

    public void setClipboardAction(ClipboardAction clipboardAction) {
        this.clipboardAction = clipboardAction;
    }

    public MapAction getMapAction() {
        return mapAction;
    }

    public void setMapAction(MapAction mapAction) {
        this.mapAction = mapAction;
    }

    public CalendarAction getCalendarAction() {
        return calendarAction;
    }

    public void setCalendarAction(CalendarAction calendarAction) {
        this.calendarAction = calendarAction;
    }

    public ComposeAction getComposeAction() {
        return composeAction;
    }

    public void setComposeAction(ComposeAction composeAction) {
        this.composeAction = composeAction;
    }
}
