package hu.bme.mit.train.sensor;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;


public class Tachograph {
    TrainController controller;
    TrainUser user;

   Table<Long, Integer, Integer> collection
            = HashBasedTable.create();

    Tachograph(TrainController c, TrainUser u){
        this.user=u;
        controller=c;
    }
    public void record(){
        collection.put(System.currentTimeMillis(), controller.getReferenceSpeed(), user.getJoystickPosition());
     }
}
