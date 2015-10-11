package asiantech.nhokquay9x26.appreviewasiantech.eventbus;

import com.squareup.otto.Bus;

public class BusProvider {
    private static Bus mBus;

    public static synchronized Bus getInstance() {
        if (mBus == null) {
            mBus = new Bus();
        }
        return mBus;
    }
}
