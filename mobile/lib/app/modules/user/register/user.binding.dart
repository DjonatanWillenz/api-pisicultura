import 'package:app/app/data/provider/user.provider.dart';
import 'package:app/app/data/repository/user.repository.dart';
import 'package:app/app/modules/user/register/user.controller.dart';
import 'package:get/get.dart';

class UserBinding implements Bindings {
  @override
  void dependencies() {
    Get.lazyPut(() => UserController());
    Get.lazyPut(() => UserRepository());
    Get.lazyPut(() => UserApiClient());
  }
}
