import 'package:app/app/global/utils/const.color.dart';
import 'package:app/app/global/widgets/widget.indicator.dart';
import 'package:app/app/modules/ph/ph.controller.dart';
import 'package:fl_chart/fl_chart.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';

// ignore: must_be_immutable
class PhView extends GetView<PhController> {
  List<Color> gradientColors = [
    const Color(0xff23b6e6),
    const Color(0xff02d39a),
  ];

  bool showAvg = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.only(
                left: UtilsColor.kPadding / 2,
                top: UtilsColor.kPadding / 2,
                right: UtilsColor.kPadding / 2,
              ),
              child: Card(
                color: UtilsColor.purpleLight,
                elevation: 3,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
                child: Container(
                  width: double.infinity,
                  child: ListTile(
                    leading: Icon(Icons.grid_on_sharp),
                    title: Text(
                      "Products Sold",
                      style: TextStyle(color: Colors.white),
                    ),
                    subtitle: Text(
                      "18% of Products Sold",
                      style: TextStyle(color: Colors.white),
                    ),
                    trailing: Chip(
                      label: Text(
                        "4,500",
                        style: TextStyle(color: Colors.white),
                      ),
                    ),
                  ),
                ),
              ),
            ),
            //-------------------------------------------------------------------------------------
            Padding(
              padding: const EdgeInsets.only(
                right: UtilsColor.kPadding / 2,
                top: UtilsColor.kPadding,
                left: UtilsColor.kPadding / 2,
              ),
              child: AspectRatio(
                aspectRatio: 1,
                child: Card(
                  color: UtilsColor.purpleLight,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20),
                  ),
                  elevation: 3,
                  child: Stack(
                    children: <Widget>[
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.stretch,
                        children: <Widget>[
                          const SizedBox(
                            height: 37,
                          ),
                          const Text(
                            'Unfold Shop 2021',
                            style: TextStyle(
                              color: Color(0xff827daa),
                              fontSize: 16,
                            ),
                            textAlign: TextAlign.center,
                          ),
                          const SizedBox(
                            height: 4,
                          ),
                          const Text(
                            'Monthly Sales',
                            style: TextStyle(
                              color: Colors.white,
                              fontSize: 20,
                              fontWeight: FontWeight.bold,
                              letterSpacing: 2,
                            ),
                            textAlign: TextAlign.center,
                          ),
                          const SizedBox(
                            height: 37,
                          ),
                          Expanded(
                            child: Padding(
                              padding:
                                  const EdgeInsets.only(right: 16.0, left: 6.0),
                              child: LineChart(
                                controller.isShowingMainData.value
                                    ? controller.sampleData1()
                                    : controller.sampleData2(),
                                swapAnimationDuration:
                                    const Duration(milliseconds: 250),
                              ),
                            ),
                          ),
                          const SizedBox(
                            height: 10,
                          ),
                        ],
                      ),
                      IconButton(
                        icon: Icon(
                          Icons.refresh,
                          color: Colors.white.withOpacity(
                              controller.isShowingMainData.value ? 1.0 : 0.5),
                        ),
                        onPressed: () {
                          controller.isShowingMainData.value =
                              !controller.isShowingMainData.value;
                        },
                      )
                    ],
                  ),
                ),
              ),
            ),
            //-------------------------------------------------------------------------------------
            Padding(
              padding: const EdgeInsets.only(
                top: UtilsColor.kPadding,
                left: UtilsColor.kPadding / 2,
                right: UtilsColor.kPadding / 2,
              ),
              child: AspectRatio(
                aspectRatio: 1,
                child: Card(
                  color: UtilsColor.purpleLight,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20),
                  ),
                  elevation: 3,
                  child: Padding(
                    padding: const EdgeInsets.all(UtilsColor.kPadding),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.stretch,
                      mainAxisAlignment: MainAxisAlignment.start,
                      mainAxisSize: MainAxisSize.max,
                      children: <Widget>[
                        Row(
                          crossAxisAlignment: CrossAxisAlignment.center,
                          mainAxisSize: MainAxisSize.min,
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: <Widget>[
                            //makeTransactionsIcon(),
                            const Text(
                              'Monthly Profits',
                              style:
                                  TextStyle(color: Colors.white, fontSize: 18),
                            ),
                            const Text(
                              r'$345,462',
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 18,
                                fontWeight: FontWeight.bold,
                              ),
                            ),
                          ],
                        ),
                        Row(
                          crossAxisAlignment: CrossAxisAlignment.center,
                          mainAxisSize: MainAxisSize.min,
                          mainAxisAlignment: MainAxisAlignment.start,
                          children: <Widget>[
                            const Text(
                              'Of ',
                              style: TextStyle(
                                  color: Color(0xff77839a), fontSize: 16),
                            ),
                            Text(
                              'Sales ',
                              style: TextStyle(
                                  color: UtilsColor.leftBarColor, fontSize: 16),
                            ),
                            const Text(
                              'And ',
                              style: TextStyle(
                                  color: Color(0xff77839a), fontSize: 16),
                            ),
                            Text(
                              'Orders',
                              style: TextStyle(
                                color: UtilsColor.rightBarColor,
                                fontSize: 16,
                              ),
                            ),
                          ],
                        ),
                        const SizedBox(
                          height: 38,
                        ),
                        Expanded(
                          child: Padding(
                            padding:
                                const EdgeInsets.symmetric(horizontal: 8.0),
                            child: Obx(
                              () => BarChart(
                                BarChartData(
                                  maxY: 20,
                                  barTouchData: BarTouchData(
                                    touchTooltipData: BarTouchTooltipData(
                                      tooltipBgColor: Colors.grey,
                                      getTooltipItem: (_a, _b, _c, _d) => null,
                                    ),
                                    touchCallback: (response) {
                                      if (response.spot == null) {
                                        controller.touchedGroupIndex.value = -1;
                                        controller.showingBarGroups.value =
                                            List.of(controller.rawBarGroups);
                                        return;
                                      }
                                      controller.touchedGroupIndex.value =
                                          response.spot.touchedBarGroupIndex;
                                      if (response.touchInput
                                              is PointerExitEvent ||
                                          response.touchInput
                                              is PointerUpEvent) {
                                        controller.touchedGroupIndex.value = -1;
                                        controller.showingBarGroups.value = List.of(
                                            // ignore: invalid_use_of_protected_member
                                            controller.rawBarGroups?.value);
                                      } else {
                                        controller.showingBarGroups.value = List.of(
                                            // ignore: invalid_use_of_protected_member
                                            controller.rawBarGroups?.value);
                                        if (controller
                                                .touchedGroupIndex.value !=
                                            -1) {
                                          var sum = 0.0;
                                          for (var rod in controller
                                              .showingBarGroups[controller
                                                  .touchedGroupIndex.value]
                                              .barRods) {
                                            sum += rod.y;
                                          }
                                          final avg = sum /
                                              controller
                                                  .showingBarGroups[controller
                                                      .touchedGroupIndex.value]
                                                  .barRods
                                                  .length;

                                          controller.showingBarGroups[controller
                                                  .touchedGroupIndex.value] =
                                              controller.showingBarGroups[
                                                      controller
                                                          .touchedGroupIndex
                                                          .value]
                                                  .copyWith(
                                            barRods: controller
                                                .showingBarGroups[controller
                                                    .touchedGroupIndex.value]
                                                .barRods
                                                .map((rod) {
                                              return rod.copyWith(y: avg);
                                            }).toList(),
                                          );
                                        }
                                      }
                                    },
                                  ),
                                  titlesData: FlTitlesData(
                                    show: true,
                                    bottomTitles: SideTitles(
                                      showTitles: true,
                                      // getTextStyles: (value) => const TextStyle(
                                      //     color: Color(0xff7589a2),
                                      //     fontWeight: FontWeight.bold,
                                      //     fontSize: 14),
                                      margin: 20,
                                      getTitles: (double value) {
                                        switch (value.toInt()) {
                                          case 0:
                                            return 'Mn';
                                          case 1:
                                            return 'Te';
                                          case 2:
                                            return 'Wd';
                                          case 3:
                                            return 'Tu';
                                          case 4:
                                            return 'Fr';
                                          case 5:
                                            return 'St';
                                          case 6:
                                            return 'Sn';
                                          default:
                                            return '';
                                        }
                                      },
                                    ),
                                    leftTitles: SideTitles(
                                      showTitles: true,
                                      // getTextStyles: (value) {
                                      //   const TextStyle(
                                      //     color: Color(0xff7589a2),
                                      //     fontWeight: FontWeight.bold,
                                      //     fontSize: 14);
                                      //   return textStyle;
                                      // },
                                      margin: 32,
                                      reservedSize: 14,
                                      getTitles: (value) {
                                        if (value == 0) {
                                          return '1K';
                                        } else if (value == 10) {
                                          return '5K';
                                        } else if (value == 19) {
                                          return '10K';
                                        } else {
                                          return '';
                                        }
                                      },
                                    ),
                                  ),
                                  borderData: FlBorderData(
                                    show: false,
                                  ),
                                  barGroups: controller.showingBarGroups,
                                ),
                              ),
                            ),
                          ),
                        ),
                        SizedBox(
                          height: 12,
                        ),
                      ],
                    ),
                  ),
                ),
              ),
            ),
            //------------------------------------------------------------------------------------
            Padding(
              padding: const EdgeInsets.only(
                  left: UtilsColor.kPadding / 2,
                  top: UtilsColor.kPadding,
                  bottom: UtilsColor.kPadding,
                  right: UtilsColor.kPadding / 2),
              child: Card(
                color: UtilsColor.purpleLight,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
                elevation: 3,
                child: Stack(
                  children: <Widget>[
                    AspectRatio(
                      aspectRatio: 1,
                      child: Container(
                        decoration: const BoxDecoration(
                          borderRadius: BorderRadius.all(
                            Radius.circular(18),
                          ),
                        ),
                        child: Padding(
                          padding: const EdgeInsets.only(
                              right: 18.0, left: 12.0, top: 24, bottom: 12),
                          child: LineChart(
                            controller.showAvg.value
                                ? controller.avgData()
                                : controller.mainData(),
                          ),
                        ),
                      ),
                    ),
                    SizedBox(
                      width: 60,
                      height: 34,
                      child: Obx(
                        () => TextButton(
                          onPressed: () {
                            controller.showAvg.value =
                                !controller.showAvg.value;
                          },
                          child: Text(
                            'avg',
                            style: TextStyle(
                              fontSize: 12,
                              color: controller.showAvg.value
                                  ? Colors.white.withOpacity(0.5)
                                  : Colors.white,
                            ),
                          ),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
            ),

            //------------------------------------------------------------------------------------
            Padding(
              padding: const EdgeInsets.only(
                left: UtilsColor.kPadding / 2,
                bottom: UtilsColor.kPadding,
                right: UtilsColor.kPadding / 2,
              ),
              child: Card(
                color: UtilsColor.purpleLight,
                elevation: 3,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
                child: Row(
                  children: <Widget>[
                    const SizedBox(
                      height: 18,
                    ),
                    Expanded(
                      child: AspectRatio(
                        aspectRatio: 1,
                        child: Obx(
                          () => PieChart(
                            PieChartData(
                              pieTouchData: PieTouchData(
                                touchCallback: (pieTouchResponse) {
                                  final desiredTouch = pieTouchResponse
                                          .touchInput is! PointerExitEvent &&
                                      pieTouchResponse.touchInput
                                          is! PointerUpEvent;
                                  if (desiredTouch &&
                                      pieTouchResponse.touchedSection != null) {
                                    controller.touchedIndex.value =
                                        pieTouchResponse
                                            .touchedSection.touchedSectionIndex;
                                  } else {
                                    controller.touchedIndex.value = -1;
                                  }
                                },
                              ),
                              borderData: FlBorderData(
                                show: false,
                              ),
                              sectionsSpace: 0,
                              centerSpaceRadius: 40,
                              sections: controller.showingSections(),
                            ),
                          ),
                        ),
                      ),
                    ),
                    Column(
                      mainAxisSize: MainAxisSize.max,
                      mainAxisAlignment: MainAxisAlignment.end,
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: const <Widget>[
                        Indicator(
                          color: Color(0xff0293ee),
                          text: 'First',
                          isSquare: true,
                        ),
                        SizedBox(
                          height: 4,
                        ),
                        Indicator(
                          color: Color(0xfff8b250),
                          text: 'Second',
                          isSquare: true,
                        ),
                        SizedBox(
                          height: 4,
                        ),
                        Indicator(
                          color: Color(0xffff5182),
                          text: 'Third',
                          isSquare: true,
                        ),
                        SizedBox(
                          height: 4,
                        ),
                        Indicator(
                          color: Color(0xff13d38e),
                          text: 'Fourth',
                          isSquare: true,
                        ),
                        SizedBox(
                          height: 18,
                        ),
                      ],
                    ),
                    const SizedBox(
                      width: 28,
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
