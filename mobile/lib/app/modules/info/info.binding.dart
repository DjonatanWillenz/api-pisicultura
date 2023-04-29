import 'package:app/app/modules/info/info.controller.dart';
import 'package:get/get.dart';

class InfoBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut<InfoController>(() => InfoController());
  }
}
