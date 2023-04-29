import 'package:app/app/data/provider/installation.provider.dart';
import 'package:app/app/data/repository/installation.repository.dart';
import 'package:app/app/modules/installation/installation.controller.dart';
import 'package:get/get.dart';

class InstallationBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => InstallationController());
    Get.lazyPut(() => InstallationApiClient());
    Get.lazyPut(() => InstallationRepository());
  }
}
