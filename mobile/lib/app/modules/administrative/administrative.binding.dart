import 'package:app/app/modules/administrative/administrative.controller.dart';
import 'package:get/get.dart';

class AdministrativeBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut<AdministrativeController>(() => AdministrativeController());
  }
}
