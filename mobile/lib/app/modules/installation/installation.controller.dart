import 'package:app/app/data/model/installation.model.dart';
import 'package:app/app/data/repository/installation.repository.dart';
import 'package:app/app/global/singletons/setings.system.dart';
import 'package:get/get.dart';

class InstallationController extends GetxController {
  final repositoty = Get.find<InstallationRepository>();

  List<Installation> itens = [];
  Future<List<Installation>> installations() async {
    if (SettingsSystem.instance != null ||
        SettingsSystem.instance.installations.length == 0)
      itens = await repositoty.find();
    SettingsSystem.instance.installations = itens;
    return itens;
  }

  onChanged(idinstallation) {
    print(installations);
  }

  onDeleteById(id) {
    print(id);
  }
}
