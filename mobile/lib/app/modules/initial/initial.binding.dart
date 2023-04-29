import 'package:app/app/data/provider/user.provider.dart';
import 'package:app/app/data/repository/user.repository.dart';
import 'package:app/app/modules/initial/initial.controller.dart';
import 'package:get/get.dart';

class InitialBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => InitialController());
    Get.lazyPut(() => UserApiClient());
    Get.lazyPut(() => UserRepository());
  }
}
