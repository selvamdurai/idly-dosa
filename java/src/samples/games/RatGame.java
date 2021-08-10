package samples.games;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RatGame {
    public static void main(String[] args) {
        Game game1 = new Game();
        Rat rat1 = new Rat(game1);
        Rat rat2 = new Rat(game1);

        System.out.println("Rat1 attack value = " + rat1.attack);
        System.out.println("Rat2 attack value = " + rat2.attack);
        System.out.println("Game's Rat attack value = " + game1.getRatAttackValue());
    }
}


class Game
{
    private int ratAttackValue=0;
    private Event<PropertyChangedEventArgs>
            propertyChanged = new Event<>();

    public Event<PropertyChangedEventArgs> getPropertyChanged() {
        return propertyChanged;
    }

    public void setPropertyChanged(Event<PropertyChangedEventArgs> propertyChanged) {
        this.propertyChanged = propertyChanged;
    }

    public int getRatAttackValue() {
        return ratAttackValue;
    }
    public void setRatAttackValue(int ratAttackValue) {
        this.ratAttackValue = ratAttackValue;
    }
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 0;
    Event<PropertyChangedEventArgs>.Subscription sub;


    public Rat(Game game)
    {
        this.game = game;
        this.attack = game.getRatAttackValue()+1;
        game.setRatAttackValue(this.attack);
        sub = this.game.getPropertyChanged().addHandler( x -> {
                    ((Rat)x.source).attack= game.getRatAttackValue();
                }
            );
        this.game.getPropertyChanged().fire(new PropertyChangedEventArgs(
                this, "attack"
        ));
    }

    @Override
    public void close() throws IOException
    {
        this.attack -=1;
        game.setRatAttackValue(this.attack);
        sub.close();
    }
}

class Event<TArgs>
{
    private int count = 0;
    private Map<Integer, Consumer<TArgs>>
            handlers = new HashMap<>();

    public Subscription addHandler(Consumer<TArgs> handler)
    {
        int i = count;
        handlers.put(count++, handler);
        return new Subscription(this, i);
    }

    public void fire(TArgs args)
    {
        for (Consumer<TArgs> handler : handlers.values())
            handler.accept(args);
    }

    public class Subscription implements AutoCloseable
    {
        private Event<TArgs> event;
        private int id;

        public Subscription(Event<TArgs> event, int id)
        {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() /*throws Exception*/
        {
            event.handlers.remove(id);
        }
    }
}


class PropertyChangedEventArgs
{
    public Object source;
    public String propertyName;

    public PropertyChangedEventArgs(Object source, String propertyName)
    {
        this.source = source;
        this.propertyName = propertyName;
    }
}