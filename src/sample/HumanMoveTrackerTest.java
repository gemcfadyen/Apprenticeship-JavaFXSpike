package sample;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class HumanMoveTrackerTest {
    @Rule
    public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

    @Test
    public void checksTextHasBeenSetWhenButtonClicked() {

        HumanMoveTracker humanMoveTracker = new HumanMoveTracker(new Text(), new GameController(new Game()));
        Button fakeButton = new Button("1");


        humanMoveTracker.registerButtonForClicking(fakeButton);

//        Event.fireEvent(your node, new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null));
      //  Event mouseEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED, 1, 1, 1, 1, MouseButton.PRIMARY, 1, false, false, false, false, true, false, false, false, false, false, null);
        //fakeButton.fireEvent(mouseEvent);
        //fakeButton.addEventHandler();
        Assert.assertThat(fakeButton.getText(), Matchers.is("X"));
        Assert.assertThat(fakeButton.isDisable(), Matchers.is(true));
    }

}