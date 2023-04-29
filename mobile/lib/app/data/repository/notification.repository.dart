import 'package:app/app/data/model/notification.model.dart';
import 'package:app/app/data/provider/notification.provider.dart';
import 'package:app/app/global/singletons/setings.system.dart';

class NotificationRepository {
  final NotificationApiClient apiClient = NotificationApiClient();

  Future<bool> deletar(id) async {
    return await apiClient.deletar(id);
  }

  Future<List<Notifications>> getNotifications(int iduser) async {
    var res = await apiClient.getUser(iduser);
    return res != null
        ? res.map<Notifications>((e) => Notifications.fromJson(e)).toList()
        : null;
  }

  Future<Notifications> register(Notifications entity) async {
    entity.iduser = SettingsSystem.instance.user.id;
        
    return Notifications.fromJson(await apiClient.register(entity));
  }
}
