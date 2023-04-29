import 'package:app/app/data/model/installation.model.dart';
import 'package:app/app/data/provider/installation.provider.dart';
import 'package:app/app/global/singletons/setings.system.dart';

class InstallationRepository {
  final InstallationApiClient apiClient = InstallationApiClient();

  find() async {
    try {
      List<dynamic> json =
          await apiClient.find(SettingsSystem.instance.user.id);
      if (json != null)
        return json.map((element) => Installation.fromMap(element));
    } catch (e) {
      print(e);
    }
  }

  update(Installation entity) async {
    return Installation.fromJson(await apiClient.update(entity));
  }
}
