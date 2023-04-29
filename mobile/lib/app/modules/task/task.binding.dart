import 'package:app/app/modules/task/task.controller.dart';
import 'package:get/get.dart';

class TaskBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut<TaskController>(() => TaskController());
    //Get.lazyPut<NotificationRepository>(() => NotificationRepository());
    //Get.lazyPut<NotificationApiClient>(() => NotificationApiClient());
  }
}
