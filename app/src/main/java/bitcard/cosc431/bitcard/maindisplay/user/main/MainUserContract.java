package bitcard.cosc431.bitcard.maindisplay.user.main;


import bitcard.cosc431.bitcard.maindisplay.user.base.BasePresenter;
import bitcard.cosc431.bitcard.maindisplay.user.base.BaseView;

/**
 * Created by Lynx on 4/11/2017.
 */

public interface MainUserContract {
    interface MainActivityView extends BaseView<MainActivityPresenter> {
        void displayDownloadContent(boolean isShown);
        void displayProgress(int percent);
        void displayPercentage(int percent);

        void displayMyBalance(String myBalance);
        void displayWalletPath(String walletPath);

        void displayMyAddress(String myAddress);
        void displayRecipientAddress(String recipientAddress);

        void showToastMessage(String message);
        String getRecipient();
        String getAmount();
        void clearAmount();

        void startScanQR();
        void displayInfoDialog(String myAddress);
    }
    interface MainActivityPresenter extends BasePresenter {
        void refresh();
        void pickRecipient();
        void send();

        void getInfoDialog();
    }
    interface MainActivityModel {

    }
}
