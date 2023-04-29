import 'package:app/app/data/provider/ph.provider.model.dart';
import 'package:app/app/data/repository/ph.repository.dart';
import 'package:app/app/modules/ph/ph.controller.dart';
import 'package:get/get.dart';

class PhBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => PhController());
    Get.lazyPut(() => PhRepository());
    Get.lazyPut(() => PhApiClient());
  }
}
