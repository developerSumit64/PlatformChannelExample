//package com.idmission;
//
//
//import android.util.JsonReader;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.annotation.Nullable;
//import androidx.core.app.NotificationCompatSideChannelService;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//import io.flutter.app.FlutterActivity;
//
//
//public class IDMissionSDK extends FlutterActivity implements ImageProcessingResponseListener, RequestResponseInterface {
//
//    private ImageProcessingSDK imageProcessingSDK = null;
//
//    boolean sdkinitlized = false;
//
//
//
//    //constructor
//    public IDMissionSDK(FlutterActivity reactContext) {
//        super(reactContext);
//    }
//
//    @Override
//    public String getName() {
//        return "IDMissionSDK";
//    }
//
//
//    @ReactMethod
//    public void  InializeSDK(String url, String loginID, String password, String merchantID, Integer productID, String productName, String language, Callback callBack) {
//        try {
//            imageProcessingSDK  =   ImageProcessingSDK.initialize(getApplicationContext(), url, loginID, password, merchantID, productID, productName, language,false);
//
//
//            imageProcessingSDK.setImageProcessingResponseListener(this);
//
//
//
//            String message = "SDK Initialized Successfully";
//
////            WritableMap params = Arguments.createMap();
////            params.putBoolean("sdkstatus",true);
////            params.putString("message",message);
////            sendEvent(getReactApplicationContext(), "InitalizationCallback", params);
//
//
//
//            callBack.invoke(true);
//
//
//
//        } catch (Exception exception) {
//
////            WritableMap params = Arguments.createMap();
////            params.putBoolean("sdkstatus",false);
////            params.putString("message",exception.getMessage());
////            sendEvent(getReactApplicationContext(), "InitalizationCallback", params);
////
//            Log.e("expection",exception.getMessage());
//
//
//            callBack.invoke(false);
//
//
//        }
//
//
//    }
//    @ReactMethod
//    public void  getGPS() {
//
//        imageProcessingSDK.getGPSCoordinate(getCurrentActivity());
//
//    }
//
//
//    @ReactMethod
//    public void  detectCard() {
//
//        imageProcessingSDK.detectCard(getCurrentActivity());
//
//    }
//
//
//    @ReactMethod
//    public void  captureFingerPrint() {
//
//        imageProcessingSDK.captureFourFingerprint(getCurrentActivity(),null);
//
//    }
//
//
//
//    @ReactMethod
//    public void  captureGenericDocuments() {
//
//        try {
//
//            String json = "{\"id_capture_portrait\":\"Y\",\"id_light_threshold\":\"70\",\"id_min_focus_threshold\":\"12\",\"id_max_focus_threshold\":\"35\",\"id_glare_percentage\":\"25\",\"id_enable_capture_button_time\":\"60\",\"id_max_image_size\":\"500\",\"id_image_height\":\"1170\",\"id_image_width\":\"800\",\"barcode_scan_max_limit\":\"15\",\"id_country\":\"USA\",\"id_state\":\"\",\"id_type\":\"PP\",\"id_mrz_retry_count\":\"15\",\"id_focus_score\":\"700\",\"id_saturation_score\":\"5\",\"id_zoom_score\":\"20\",\"id_disable_rectangle_drawing\":\"Y\"}";
//            JSONObject commonFunctioObject = new JSONObject(json);
//
//
//            Log.e("json",commonFunctioObject+"");
//
//
//
//            ImageProcessingSDK.getInstance().autoCapture(getCurrentActivity(), ImageType.GENERIC_DOCUMENT, commonFunctioObject, null, null);
//
//
//        }
//        catch (Exception e)
//        {
//
//        }
//    }
//
//
//    @ReactMethod
//    public void  detectFace() {
//
//        imageProcessingSDK.detectFace(getCurrentActivity());
//    }
//
//    @ReactMethod
//    public void  captureFrontImage() {
//
//        try {
//
//            String json = "{\"id_capture_portrait\":\"Y\",\"id_light_threshold\":\"70\",\"id_min_focus_threshold\":\"12\",\"id_max_focus_threshold\":\"35\",\"id_glare_percentage\":\"25\",\"id_enable_capture_button_time\":\"60\",\"id_max_image_size\":\"500\",\"id_image_height\":\"1170\",\"id_image_width\":\"800\",\"barcode_scan_max_limit\":\"15\",\"id_country\":\"USA\",\"id_state\":\"\",\"id_type\":\"PP\",\"id_mrz_retry_count\":\"15\",\"id_focus_score\":\"700\",\"id_saturation_score\":\"5\",\"id_zoom_score\":\"20\",\"id_disable_rectangle_drawing\":\"Y\"}";
//            JSONObject commonFunctioObject = new JSONObject(json);
//
//
//            Log.e("json",commonFunctioObject+"");
//
//
//
//            ImageProcessingSDK.getInstance().autoCapture(getCurrentActivity(), ImageType.FRONT, commonFunctioObject, null, null);
//
//
//        }
//        catch (Exception e)
//        {
//
//        }
//
//    }
//
//
//    @ReactMethod
//    public void  videoConfrencing() {
//
//        imageProcessingSDK.startVideoConferencing(getCurrentActivity(),null);
//
//    }
//
//
//
//
//    @ReactMethod
//    public void  verifyCustomer() {
//
//
//        if(imageProcessingSDK != null) {
//
//
//            imageProcessingSDK.verifyCustomer(getCurrentActivity(), "FACE");
//        }
//    }
//
//
//
//
//    @ReactMethod
//    public void  genericApiCalls(String json) {
//
//        try {
//            imageProcessingSDK.genericApiCall(getCurrentActivity(), new JSONObject(json));
//
//        }
//        catch(Exception e)
//        {
//
//        }
//    }
//
//    @ReactMethod
//    public void  captureBackImage() {
//
//        try {
//
//            String json = "{\"id_capture_portrait\":\"Y\",\"id_light_threshold\":\"70\",\"id_min_focus_threshold\":\"12\",\"id_max_focus_threshold\":\"35\",\"id_glare_percentage\":\"25\",\"id_enable_capture_button_time\":\"60\",\"id_max_image_size\":\"500\",\"id_image_height\":\"1170\",\"id_image_width\":\"800\",\"barcode_scan_max_limit\":\"15\",\"id_country\":\"USA\",\"id_state\":\"\",\"id_type\":\"PP\",\"id_mrz_retry_count\":\"15\",\"id_focus_score\":\"700\",\"id_saturation_score\":\"5\",\"id_zoom_score\":\"20\",\"id_disable_rectangle_drawing\":\"Y\"}";
//            JSONObject commonFunctioObject = new JSONObject(json);
//
//
//            Log.e("json",commonFunctioObject+"");
//
//
//
//            ImageProcessingSDK.getInstance().autoCapture(getCurrentActivity(), ImageType.BACK, commonFunctioObject, null, null);
//
//
//        }
//        catch (Exception e)
//        {
//
//        }
//
//    }
//
//
//    @ReactMethod
//    public void  recordVoice(int time,boolean use_ui) {
//
//        imageProcessingSDK.startVoiceRecording(getCurrentActivity(),time,use_ui);
//
//    }
//
//    @ReactMethod
//    public void  recordVideo(int time,String text) {
//
//        imageProcessingSDK.startVideoRecording(getCurrentActivity(),time,null,text);
//
//    }
//
//    @ReactMethod
//    public void getSignature()
//    {
//        imageProcessingSDK.captureSignature(getCurrentActivity());
//    }
//
//    @ReactMethod
//    public void initLabels(String eng_labels,String spn_labels)
//    {
//
//        try {
//
//            imageProcessingSDK.initializeLabels(jsonToMap(eng_labels), jsonToMap(spn_labels));
//        }
//
//        catch (Exception e)
//        {
//
//
//        }
//
//    }
//
//
//    public  HashMap<String,String> jsonToMap(String t) throws JSONException {
//
//        HashMap<String, String> map = new HashMap<String, String>();
//        JSONObject jObject = new JSONObject(t);
//        Iterator<?> keys = jObject.keys();
//
//        while( keys.hasNext() ){
//            String key = (String)keys.next();
//            String value = jObject.getString(key);
//            map.put(key, value);
//
//        }
//
//
//        return  map;
//    }
//
//
//    @ReactMethod
//    public void clearFingerPrint()
//    {
//        try {
//            imageProcessingSDK.clearFingerprint(FingerType.LIFINGER);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @ReactMethod
//    public void customizeUI(String json)
//    {
//        try {
//            imageProcessingSDK.customizeUserInterface(new JSONObject(json));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @ReactMethod
//    public void scanBarCode()
//    {
//        imageProcessingSDK.scanBarcode(getCurrentActivity(),null);
//    }
//
//
//    @ReactMethod
//    public void  TestMethod(String message) {
//        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_SHORT).show();
//    }
//
//    private void sendEvent(ReactContext reactContext,
//                           String eventName,
//                           @Nullable WritableMap params) {
//        reactContext
//                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
//                .emit(eventName, params);
//    }
//
//
//
//
//
//
//    @Override
//    public void onImageProcessingResultAvailable(Map<String, String> map, Response response) {
//
//        Log.e("map111",map.toString());
//
//    }
//
//    @Override
//    public void onAutoImageCaptureResultAvailable(Map<String, String> map, Response response) {
//
//
//        Log.e("auto","image");
//
//        WritableMap params = Arguments.createMap();
//
//        String image = "";
//
//        if(map.containsKey("FRONT")) {
//
//            image = map.get("FRONT");
//
//        }
//        else if(map.containsKey("BACK")){
//            image = map.get("BACK");
//        }
//        else
//        {
//            image = map.get("GENERIC");
//
//        }
//
//
//        if(image !=null) {
//
//            try {
//
//                params.putString("data", image);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            sendEvent(getReactApplicationContext(), "ImageCallback", params);
//
//            Log.e("gps", map.toString());
//
//        }
//
//    }
//
//    @Override
//    public void onAutoFillResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onAutoFillFieldInformationAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onFaceDetectionResultAvailable(Map<String, String> map, Response response) {
//
//
//
//        WritableMap params = Arguments.createMap();
//
//        String image = map.get("FACE");
//        if(image!=null) {
//
//            try {
//
//                params.putString("data", image);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
////            params.putString("data", image);
//
//            sendEvent(getReactApplicationContext(), "ImageCallback", params);
//
//        }
//
//
//    }
//
//    @Override
//    public void onFaceMatchingResultAvailable(Map<String, String> map, Response response) {
//        Log.e("map11",map.toString());
//    }
//
//    @Override
//    public void onCardDetectionResultAvailable(Map<String, String> map, Response response) {
//
//        WritableMap params = Arguments.createMap();
//
//        params.putString("data",new JSONObject(map).toString());
//        sendEvent(getReactApplicationContext(), "DetectCardCallback", params);
//
//        Log.d("gps",map.toString());
//
//
//    }
//
//    @Override
//    public void onCaptureProofOfAddressResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onCaptureBankStatementResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onCaptureGenericDocumentResultAvailable(Map<String, String> map, Response response) {
//
//
//
//
//        Log.e("generic",map.toString());
//        WritableMap params = Arguments.createMap();
//
//        String image = map.get("GENERIC_DOCUMENT");
//        if(image!=null) {
//
//            try {
//
//                params.putString("data", image);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
////            params.putString("data", image);
//
//            sendEvent(getReactApplicationContext(), "ImageCallback", params);
//
//        }
//
//    }
//
//    @Override
//    public void onCaptureBirthCertificateResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onImageProcessingAndFaceMatchingResultAvailable(Map<String, String> map, Response response) {
//        Log.e("map2",map.toString());
//
//    }
//
//    @Override
//    public void onOperationResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onCustomerVerificationResultAvailable(Map<String, String> map, Response response) {
//
//
//        Log.d("verify",map.toString());
//
//
//
//    }
//
//    @Override
//    public void onCustomizeUserInterfaceResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onVoiceRecordingFinished(Map<String, String> map, Response response) {
//
//
//
//
////        WritableMap params = Arguments.createMap();
//
//        if(map!=null) {
//            Log.e("gps coordinates", map + "data");
//            WritableMap params = Arguments.createMap();
//            params.putString("data", new JSONObject(map).toString());
//            sendEvent(getReactApplicationContext(), "VoiceCallback", params);
//
//        }
//        else
//        {
//            Log.e("map","is null");
//        }
//
//
////        Log.d("gps", response.getStatusCode()+"");
////        if(response.getStatusCode() == 1) {
////            params.putString("data", new JSONObject(map).toString());
////            sendEvent(getReactApplicationContext(), "VoiceCallback", params);
////
////            Log.d("gps", map.toString());
////
////        }
//
//
//
//    }
//
//    @Override
//    public void onGPSCoordinateAvailable(Map<String, String> map, Response response) {
//        if(map!=null) {
//            Log.e("gps coordinates", map + "data");
//            WritableMap params = Arguments.createMap();
//            params.putString("data",map.toString());
//            sendEvent(getReactApplicationContext(), "GPSCallback", params);
//
//        }
//        else
//        {
//            Log.e("map","is null");
//        }
////
//
//    }
//
//    @Override
//    public void onFourFingerCaptureFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onFingerprintCaptureFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onFingerprintEnrolmentFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onFingerprintVerificationFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onVideoRecordingFinished(Map<String, String> map, Response response) {
//
//
//        if(map!=null) {
//            WritableMap params = Arguments.createMap();
//
//            params.putString("data",new JSONObject(map).toString());
//
//            sendEvent(getReactApplicationContext(), "VideoCallback", params);
//
//        }
//        else
//        {
//            Log.e("map","is null");
//        }
////        WritableMap params = Arguments.createMap();
////
////        params.putString("data",new JSONObject(map).toString());
////
////        sendEvent(getReactApplicationContext(), "VideoCallback", params);
//
//
//
//    }
//
//    @Override
//    public void onScanBarcodeFinished(Map<String, String> map, Response response) {
//
//
//
//        WritableMap params = Arguments.createMap();
//
//        params.putString("data",new JSONObject(map).toString());
//        sendEvent(getReactApplicationContext(), "BarCodeCallback", params);
//
//
//
//    }
//
//    @Override
//    public void onCaptureSignatureFinished(Map<String, String> map, Response response) {
//
//        WritableMap params = Arguments.createMap();
//
//        params.putString("data",new JSONObject(map).toString());
//        sendEvent(getReactApplicationContext(), "SignatureCallback", params);
//
//
//
//    }
//
//    @Override
//    public void onVerifyAddressFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onCreateEmployeeFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onVerifyEmployeeFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onGenerateTokenFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onVerifyTokenFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onSnippetImageCaptureResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onUpdateCustomerFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onGenerateOTPFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onVerifyOTPFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onInitializationResultAvailable(Map<String, String> map, Response response) {
//
//        Log.e(response.getStatusCode()+"",response.getStatusMessage());
//    }
//
//    @Override
//    public void onExecuteCustomProductCall(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onUpdateEmployeeFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void onIDValidationAndVideoMatchingFinished(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void genericApiCallResponse(Map<String, String> map, Response response) {
//
//
//        WritableMap params = Arguments.createMap();
//
//        params.putString("data",new JSONObject(map).toString());
//        sendEvent(getReactApplicationContext(), "GenericCallback", params);
//
//
//    }
//
//    @Override
//    public void onVideoConferencingFinished(Map<String, String> map, Response response) {
//
//        WritableMap params = Arguments.createMap();
//
//        params.putString("data",new JSONObject(map).toString());
//        sendEvent(getReactApplicationContext(), "VCCallback", params);
//
//    }
//
//    @Override
//    public void onDownloadXsltResultAvailable(Map<String, String> map, Response response) {
//
//    }
//
//    @Override
//    public void cancelPogressBar() {
//
//    }
//}
