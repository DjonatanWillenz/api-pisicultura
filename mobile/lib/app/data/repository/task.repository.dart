import 'package:app/app/data/enum/task.state.enum.dart';
import 'package:app/app/data/model/task.model.dart';
import 'package:app/app/data/provider/task.provider.dart';

class TaskRepository {
  final TaskApiClient apiClient = TaskApiClient();

  Future<List<Task>> find() async {
    List<Task> result = [];
    // var res = await apiClient.find(SettingsSystem.instance.user.id);
    // if (res != null) result = res.map<Task>((e) => Task.fromJson(e)).toList();

    Task task = new Task();
    task.id = 1;
    task.title = "PH";
    task.description = "Atualização informação PH";
    task.state = TaskStateEnumm.CONCLUSED;

    result.add(task);

    Task taskTM = new Task();
    taskTM.title = "Temperatura";
    taskTM.description = "Atualização informação da temperatura";
    result.add(taskTM);

    Task taskOX = new Task();
    taskOX.title = "Oxigenação";
    taskOX.description = "Atualização informação do nível de oxigenação";
    result.add(taskOX);

    task.title = "PH";
    task.description = "Atualização informação PH";
    result.add(task);

    return result;
  }

  deleteById(int id) {}
}
