import 'package:app/app/data/provider/installation.setting.provider.dart';
import 'package:app/app/data/repository/installation.setting.repository.dart';
import 'package:app/app/modules/settings/setting.system.controller.dart';
import 'package:get/get.dart';

class SettingsSystemBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => SettingSystemController());
    Get.lazyPut(() => InstallationSettingApiClient());
    Get.lazyPut(() => InstallationSettingRepository());
  }
}
