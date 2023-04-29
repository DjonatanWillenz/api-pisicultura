import 'package:app/app/global/widgets/widget.card.dart';
import 'package:app/app/global/widgets/widget_icon_button.dart';
import 'package:app/app/modules/home/components/widget.app.bar.home.dart';
import 'package:app/app/modules/home/components/widget.botton.bar.home.dart';
import 'package:app/app/modules/home/components/widget.drawer.dart';
import 'package:app/app/modules/home/components/widget.task.home.dart';
import 'package:app/app/modules/home/home.controller.dart';
import 'package:app/app/themes/app_theme.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

class HomeView extends GetView<HomeController> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: DwAppBarHome(controller: controller),
      drawer: DwDrawer(itens: controller.findItensDrawer()),
      body: CustomScrollView(
        physics: ClampingScrollPhysics(),
        slivers: <Widget>[
          SliverPadding(
            padding: EdgeInsets.all(20.0),
            sliver: SliverToBoxAdapter(
              child: Text(
                'Dashboard',
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 25.0,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
          ),
          SliverPadding(
            padding: const EdgeInsets.all(.01),
            sliver: SliverToBoxAdapter(
              child: Flexible(
                child: Row(
                  children: <Widget>[
                    DwCard(
                      title: 'PH',
                      count: 6.4
                          .toString(), //controller.dashboard.ph.value.toString(),
                      color: Colors.red,
                    ),
                    DwCard(
                      title: 'Temperatura',
                      count:
                          27.2.toString() + //controller.dashboard.temperature.value.toString() +
                              ' °C',
                      color: Colors.yellow,
                    ),
                    DwCard(
                      title: 'Oxigenação',
                      count:
                          4.6.toString() + // controller.dashboard.oxygenation.value.toString() +
                              ' mg/l',
                      color: Colors.purple,
                    ),
                  ],
                ),
              ),
            ),
          ),
          /*    SliverPadding(
            padding: const EdgeInsets.all(.01),
            sliver: SliverToBoxAdapter(
              child: Flexible(
                child: Row(
                  children: <Widget>[
                    
                   
                    
                  ],
                ),
              ),
            ),
          ),
        */
          SliverPadding(
            padding: EdgeInsets.only(top: 10.0, left: 5),
            sliver: SliverToBoxAdapter(
              child: ListTile(
                title: Text(
                  'Tarefas',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 20.0,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                trailing: DwIconButton(
                  icon: Icons.refresh,
                  sizeIcon: 25,
                  corIcon: Colors.orange,
                  onPressed: () => controller.taskRepository.find(),
                ),
              ),
            ),
          ),
          SliverPadding(
            padding: EdgeInsets.all(2),
            sliver: SliverToBoxAdapter(
              child: Container(
                decoration: BoxDecoration(
                  color: appThemeData().backgroundColor,
                  borderRadius: BorderRadius.only(
                    topLeft: Radius.circular(10),
                    topRight: Radius.circular(10),
                  ),
                ),
                height: Get.height * 0.6,
                child: DwListCardsTasks(repository: controller.taskRepository),
              ),
            ),
          )
        ],
      ),
      bottomNavigationBar: DwBottonBarHome(),
    );
  }

  DwAppBarHome newMethod() => DwAppBarHome();
}
