package backend;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author Mark Steneker
 */
public class Match{
    private final SimpleStringProperty lostLabelID;
    private final SimpleStringProperty foundLabelID;
    private final SimpleStringProperty lostFoundID;
    private final SimpleStringProperty status;
     
    public Match(String lostLabelID, String foundLabelID, String lostFoundID, String status) {
        this.lostLabelID = new SimpleStringProperty(lostLabelID);
        this.foundLabelID = new SimpleStringProperty(foundLabelID);
        this.lostFoundID = new SimpleStringProperty(lostFoundID);
        this.status = new SimpleStringProperty(status);
    }

    public String getLostLabelID(){   
        return this.lostLabelID.get();
    }
    
    public String getFoundLabelID(){   
        return this.foundLabelID.get();
    }
    
    public String getLostFoundID(){   
        return this.lostFoundID.get();
    }
    
    public String getStatus(){   
        return this.status.get();
    }
    
}
