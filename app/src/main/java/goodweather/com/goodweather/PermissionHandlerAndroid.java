package goodweather.com.goodweather;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.INTERNET;

public class PermissionHandlerAndroid implements PermissionsHandler {

    private AppCompatActivity activity;

    private ArrayList<String> permissionsToRequest;
    private String[] permissionsRejected;
    private List<String> permissions ;

    private final static int ALL_PERMISSIONS_RESULT = 101;

    public PermissionHandlerAndroid(AppCompatActivity activity) {
        permissionsRejected = new String[]{};
        permissions = new ArrayList<>();
        permissionsToRequest = new ArrayList<>();
        this.activity = activity;
    }

    public void getPermissions(){
        permissions.add(ACCESS_FINE_LOCATION);
        permissions.add(ACCESS_COARSE_LOCATION);
        permissions.add(INTERNET);

        for(String permission : permissions) {
            if(!checkHasPermission(permission)) {
                permissionsToRequest.add(permission);
            }
        }
        if(!permissionsToRequest.isEmpty()) {
            String[] pe = new String[permissionsToRequest.size()];
            permissionsToRequest.toArray(pe);

            //    String[] pe = (String[]) permissionsToRequest.toArray();
            requestPermission(pe, ALL_PERMISSIONS_RESULT);
        }
    }

    @Override
    public boolean checkHasPermission(String permission) {
        return PermissionChecker.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void requestPermission(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.requestPermissions(permissions,requestCode);
        }else {
            ActivityCompat.requestPermissions(activity, permissions, requestCode);
        }
    }
}
