package bitcard.cosc431.bitcard.maindisplay.user.base;

/**
 * Created by Lynx on 4/11/2017.
 */

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
