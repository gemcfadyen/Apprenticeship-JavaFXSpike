package sample;

import org.junit.Rule;
import org.junit.Test;

public class ActionTrackerTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Test
    public void checksTextHasBeenSetWhenButtonClicked() {
//        ActionTracker humanMoveTracker = new ActionTracker(new Text(), new GameController(new Game()));
//        Button fakeButton = new Button("1");
//

        // humanMoveTracker.registerElementForClicking(fakeButton);

//        Event.fireEvent(your node, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null));
        //  Event mouseEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED, 1, 1, 1, 1, MouseButton.PRIMARY, 1, false, false, false, false, true, false, false, false, false, false, null);
        //fakeButton.fireEvent(mouseEvent);
        //fakeButton.addEventHandler();
//        Assert.assertThat(fakeButton.getText(), Matchers.is("X"));
//        Assert.assertThat(fakeButton.isDisable(), Matchers.is(true));
    }

}