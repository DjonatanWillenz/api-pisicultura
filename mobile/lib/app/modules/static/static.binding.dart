import 'package:app/app/modules/static/static.controller.dart';
import 'package:get/get.dart';

class EstatisticaBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => StaticController());
  }
}
