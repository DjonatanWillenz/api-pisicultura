import 'package:app/app/data/base.url.dart';
import 'package:app/app/data/provider/dwGetConnect.dart';

class TaskApiClient extends DwGetConnect {
  find(int iduser) async {
    try {
      final response = await get(baseUrl + '/app/task/$iduser');
      return response.statusCode == 201 ? response.body as List : null;
    } catch (e) {
      return null;
    }
  }
}
