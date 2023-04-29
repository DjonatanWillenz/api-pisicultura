import 'package:app/app/modules/store/store.controller.dart';
import 'package:get/get.dart';

class StoreBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut<StoreController>(() => StoreController());
    //Get.lazyPut<NotificationRepository>(() => NotificationRepository());
    //Get.lazyPut<NotificationApiClient>(() => NotificationApiClient());
  }
}
