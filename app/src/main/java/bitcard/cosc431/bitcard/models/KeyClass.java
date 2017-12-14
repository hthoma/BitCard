package bitcard.cosc431.bitcard.models;

import java.util.UUID;

/**
 * Created by hthoma on 12/13/17.
 */

public class KeyClass {
    String publickey,ID;

    public KeyClass() {
    }

    public KeyClass(String publickey) {
        this.publickey = publickey;
        this.ID = UUID.randomUUID().toString();
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
