<template>
    <div class="item">
    <v-chart class="chart" :option="option" />
    <slot></slot>
    </div>
  </template>
  
  <script setup>
  import { use } from 'echarts/core'
  import { SankeyChart } from 'echarts/charts'
  import { TitleComponent, TooltipComponent } from 'echarts/components'
  import { CanvasRenderer } from 'echarts/renderers'
  import VChart from "vue-echarts";
  import { ref } from "vue";
  
  use([TitleComponent, TooltipComponent, SankeyChart, CanvasRenderer])
  
  
  const option = ref({
  title: {
        text: 'Sankey Diagram'
      },
      tooltip: {
        trigger: 'item',
        triggerOn: 'mousemove'
      },
      series: [
        {
          type: 'sankey',
          data: [
            {
              name: 'part1'
            },
            {
              name: 'part2'
            },
            {
              name: 'GUN'
            },
            {
              name: 'HAND GUN'
            },
            {
              name: 'UNKNOWN FIREARM'
            },
            {
              name: 'SEMI-AUTOMATIC PISTOL'
            },
            {
              name: 'KNIFE'
            },
            {
              name: 'KNIFE WITH BLADE 6INCHES OR LESS'
            },
            {
              name: 'OTHER KNIFE'
            },
            {
              name: 'VEHICLE'
            },
            {
              name: 'BODILY FORCE'
            },
            {
              name: 'OTHER TYPES'
            },
            {
              name: 'UNKNOWN WEAPON'
            },
            {
              name: 'VERBAL THREAT'
            },
            {
              name: 'MACE/PEPPER SPRAY'
            },
            {
              name: 'AA'
            },
            {
              name: 'AO'
            },
            {
              name: 'IC'
            },
            {
              name: 'JA'
            },
            {
              name: 'JO'
            },
          ],
          links: [
            {
              source: 'part1',
              target: 'GUN',
              value: 925
            },
            {
              source: 'part1',
              target: 'KNIFE',
              value: 394
            },
            {
              source: 'part1',
              target: 'VEHICLE',
              value: 93
            },
            {
              source: 'part1',
              target: 'BODILY FORCE',
              value: 1239
            },
            {
              source: 'part1',
              target: 'OTHER TYPES',
              value: 951
            },
            {
              source: 'part2',
              target: 'GUN',
              value: 94
            },
            {
              source: 'part2',
              target: 'KNIFE',
              value: 7
            },
            {
              source: 'part2',
              target: 'VEHICLE',
              value: 11
            },
            {
              source: 'part2',
              target: 'BODILY FORCE',
              value: 4155
            },
            {
              source: 'part2',
              target: 'OTHER TYPES',
              value: 1158
            },
            {
              source: 'GUN',
              target: 'HAND GUN',
              value: 632
            },
            {
              source: 'GUN',
              target: 'UNKNOWN FIREARM',
              value: 179
            },
            {
              source: 'GUN',
              target: 'SEMI-AUTOMATIC PISTOL',
              value: 208
            },
            {
              source: 'KNIFE',
              target: 'KNIFE WITH BLADE 6INCHES OR LESS',
              value: 236
            },
            {
              source: 'KNIFE',
              target: 'OTHER KNIFE',
              value: 165
            },
            {
              source: 'OTHER TYPES',
              target: 'UNKNOWN WEAPON',
              value: 1197
            },
            {
              source: 'OTHER TYPES',
              target: 'VERBAL THREAT',
              value: 782
            },
            {
              source: 'OTHER TYPES',
              target: 'MACE/PEPPER SPRAY',
              value: 130
            },
            {
              source: 'HAND GUN',
              target: 'AA',
              value: 81
            },
            {
              source: 'HAND GUN',
              target: 'AO',
              value: 46
            },
            {
              source: 'HAND GUN',
              target: 'IC',
              value: 498
            },
            {
              source: 'HAND GUN',
              target: 'JA',
              value: 6
            },
            {
              source: 'HAND GUN',
              target: 'JO',
              value: 1
            },
            {
              source: 'UNKNOWN FIREARM',
              target: 'AA',
              value: 19
            },
            {
              source: 'UNKNOWN FIREARM',
              target: 'AO',
              value: 9
            },
            {
              source: 'UNKNOWN FIREARM',
              target: 'IC',
              value: 149
            },
            {
              source: 'UNKNOWN FIREARM',
              target: 'JA',
              value: 2
            },
            {
              source: 'SEMI-AUTOMATIC PISTOL',
              target: 'AA',
              value: 29
            },
            {
              source: 'SEMI-AUTOMATIC PISTOL',
              target: 'AO',
              value: 14
            },
            {
              source: 'SEMI-AUTOMATIC PISTOL',
              target: 'IC',
              value: 162
            },
            {
              source: 'SEMI-AUTOMATIC PISTOL',
              target: 'JA',
              value: 3
            },
            {
              source: 'KNIFE WITH BLADE 6INCHES OR LESS',
              target: 'AA',
              value: 59
            },
            {
              source: 'KNIFE WITH BLADE 6INCHES OR LESS',
              target: 'AO',
              value: 42
            },
            {
              source: 'KNIFE WITH BLADE 6INCHES OR LESS',
              target: 'IC',
              value: 129
            },
            {
              source: 'KNIFE WITH BLADE 6INCHES OR LESS',
              target: 'JA',
              value: 4
            },
            {
              source: 'KNIFE WITH BLADE 6INCHES OR LESS',
              target: 'JO',
              value: 2
            },
            {
              source: 'OTHER KNIFE',
              target: 'AA',
              value: 31
            },
            {
              source: 'OTHER KNIFE',
              target: 'AO',
              value: 20
            },
            {
              source: 'OTHER KNIFE',
              target: 'IC',
              value: 112
            },
            {
              source: 'OTHER KNIFE',
              target: 'JA',
              value: 2
            },
            {
              source: 'VEHICLE',
              target: 'AA',
              value: 25
            },
            {
              source: 'VEHICLE',
              target: 'AO',
              value: 9
            },
            {
              source: 'VEHICLE',
              target: 'IC',
              value: 70
            },
            {
              source: 'BODILY FORCE',
              target: 'AA',
              value: 571
            },
            {
              source: 'BODILY FORCE',
              target: 'AO',
              value: 984
            },
            {
              source: 'BODILY FORCE',
              target: 'IC',
              value: 3780
            },
            {
              source: 'BODILY FORCE',
              target: 'JA',
              value: 34
            },
            {
              source: 'BODILY FORCE',
              target: 'JO',
              value: 25
            },
            {
              source: 'UNKNOWN WEAPON',
              target: 'AA',
              value: 115
            },
            {
              source: 'UNKNOWN WEAPON',
              target: 'AO',
              value: 119
            },
            {
              source: 'UNKNOWN WEAPON',
              target: 'IC',
              value: 958
            },
            {
              source: 'UNKNOWN WEAPON',
              target: 'JA',
              value: 2
            },
            {
              source: 'UNKNOWN WEAPON',
              target: 'JO',
              value: 3
            },
            {
              source: 'VERBAL THREAT',
              target: 'AA',
              value: 118
            },
            {
              source: 'VERBAL THREAT',
              target: 'AO',
              value: 121
            },
            {
              source: 'VERBAL THREAT',
              target: 'IC',
              value: 539
            },
            {
              source: 'VERBAL THREAT',
              target: 'JA',
              value: 1
            },
            {
              source: 'VERBAL THREAT',
              target: 'JO',
              value: 3
            },
            {
              source: 'MACE/PEPPER SPRAY',
              target: 'AA',
              value: 11
            },
            {
              source: 'MACE/PEPPER SPRAY',
              target: 'AO',
              value: 13
            },
            {
              source: 'MACE/PEPPER SPRAY',
              target: 'IC',
              value: 105
            },
            {
              source: 'MACE/PEPPER SPRAY',
              target: 'JA',
              value: 1
            },
          ],
          emphasis: {
            focus: 'adjacency'
          },
          levels: [
            {
              depth: 0,
              itemStyle: {
                color: '#fbb4ae'
              },
              lineStyle: {
                color: 'source',
                opacity: 0.6
              }
            },
            {
              depth: 1,
              itemStyle: {
                color: '#b3cde3'
              },
              lineStyle: {
                color: 'source',
                opacity: 0.6
              }
            },
            {
              depth: 2,
              itemStyle: {
                color: '#ccebc5'
              },
              lineStyle: {
                color: 'source',
                opacity: 0.6
              }
            },
            {
              depth: 3,
              itemStyle: {
                color: '#decbe4'
              },
              lineStyle: {
                color: 'source',
                opacity: 0.6
              }
            }
          ],
          lineStyle: {
            curveness: 0.5
          }
        }
      ]
  }
  );
  </script>
  
  <style>
  .item{
    height: 20rem;
    border: 1px solid blue;
    margin: .500rem;
    background-color: rgba(255, 0, 0, .15);
  }
  
  .chart {
  height: 400px;
  }
  </style>