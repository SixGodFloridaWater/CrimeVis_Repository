<template>
  <v-chart class="chart" :option="option" />
</template>

<script setup>
import { use } from 'echarts/core'
import { SankeyChart } from 'echarts/charts'
import { TitleComponent, TooltipComponent } from 'echarts/components'
import { CanvasRenderer } from 'echarts/renderers'
import VChart from "vue-echarts";
import { ref, defineProps } from "vue";

use([TitleComponent, TooltipComponent, SankeyChart, CanvasRenderer])
const props = defineProps(['linkdata']);

let option = ref({
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
      name: 'gun'
      },
      {
      name: 'hand gun'
      },
      {
      name: 'unknown firearm'
      },
      {
      name: 'semi-automatic pistol'
      },
      {
      name: 'knife'
      },
      {
      name: 'knife with blade 6inches or less'
      },
      {
      name: 'other knife'
      },
      {
      name: 'vehicle'
      },
      {
      name: 'bodily force'
      },
      {
      name: 'other types'
      },
      {
      name: 'unknown weapon'
      },
      {
      name: 'verbal threat'
      },
      {
      name: 'mace/pepper spray'
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
      target: 'gun',
      value: props.linkdata.part1_gun
      },
      {
      source: 'part1',
      target: 'knife',
      value: props.linkdata.part1_knife
      },
      {
      source: 'part1',
      target: 'vehicle',
      value: props.linkdata.part1_vehicle
      },
      {
      source: 'part1',
      target: 'bodily force',
      value: props.linkdata.part1_bodily_force
      },
      {
      source: 'part1',
      target: 'other types',
      value: props.linkdata.part1_other_types
      },
      {
      source: 'part2',
      target: 'gun',
      value: props.linkdata.part2_gun
      },
      {
      source: 'part2',
      target: 'knife',
      value: props.linkdata.part2_knife
      },
      {
      source: 'part2',
      target: 'vehicle',
      value: props.linkdata.part2_vehicle
      },
      {
      source: 'part2',
      target: 'bodily force',
      value: props.linkdata.part2_bodily_force
      },
      {
      source: 'part2',
      target: 'other types',
      value: props.linkdata.part2_other_types
      },
      {
      source: 'gun',
      target: 'hand gun',
      value: props.linkdata.gun_handgun
      },
      {
      source: 'gun',
      target: 'unknown firearm',
      value: props.linkdata.gun_unknown_firearm
      },
      {
      source: 'gun',
      target: 'semi-automatic pistol',
      value: props.linkdata.gun_semi_automatic_pistol
      },
      {
      source: 'knife',
      target: 'knife with blade 6inches or less',
      value: props.linkdata.knife_knife_with_blade_6inches_or_less
      },
      {
      source: 'knife',
      target: 'other knife',
      value: props.linkdata.knife_other_knife
      },
      {
      source: 'other types',
      target: 'unknown weapon',
      value: props.linkdata.other_types_unknown_weapon
      },
      {
      source: 'other types',
      target: 'verbal threat',
      value: props.linkdata.other_types_verbal_threat
      },
      {
      source: 'other types',
      target: 'mace/pepper spray',
      value: props.linkdata.other_types_mace_pepper_spray
      },
      {
      source: 'hand gun',
      target: 'AA',
      value: props.linkdata.handgun_AA
      },
      {
      source: 'hand gun',
      target: 'AO',
      value: props.linkdata.handgun_AO
      },
      {
      source: 'hand gun',
      target: 'IC',
      value: props.linkdata.handgun_IC
      },
      {
      source: 'hand gun',
      target: 'JA',
      value: props.linkdata.handgun_JA
      },
      {
      source: 'hand gun',
      target: 'JO',
      value: props.linkdata.handgun_JO
      },
      {
      source: 'unknown firearm',
      target: 'AA',
      value: props.linkdata.unknown_firearm_AA
      },
      {
      source: 'unknown firearm',
      target: 'AO',
      value: props.linkdata.unknown_firearm_AO
      },
      {
      source: 'unknown firearm',
      target: 'IC',
      value: props.linkdata.unknown_firearm_IC
      },
      {
      source: 'unknown firearm',
      target: 'JA',
      value: props.linkdata.unknown_firearm_JA
      },
      {
      source: 'semi-automatic pistol',
      target: 'AA',
      value: props.linkdata.semi_automatic_pistol_AA
      },
      {
      source: 'semi-automatic pistol',
      target: 'AO',
      value: props.linkdata.semi_automatic_pistol_AO
      },
      {
      source: 'semi-automatic pistol',
      target: 'IC',
      value: props.linkdata.semi_automatic_pistol_IC
      },
      {
      source: 'semi-automatic pistol',
      target: 'JA',
      value: props.linkdata.semi_automatic_pistol_JA
      },
      {
      source: 'knife with blade 6inches or less',
      target: 'AA',
      value: props.linkdata.knife_with_blade_6inches_or_less_AA
      },
      {
      source: 'knife with blade 6inches or less',
      target: 'AO',
      value: props.linkdata.knife_with_blade_6inches_or_less_AO
      },
      {
      source: 'knife with blade 6inches or less',
      target: 'IC',
      value: props.linkdata.knife_with_blade_6inches_or_less_IC
      },
      {
      source: 'knife with blade 6inches or less',
      target: 'JA',
      value: props.linkdata.knife_with_blade_6inches_or_less_JA
      },
      {
      source: 'knife with blade 6inches or less',
      target: 'JO',
      value: props.linkdata.knife_with_blade_6inches_or_less_JO
      },
      {
      source: 'other knife',
      target: 'AA',
      value: props.linkdata.other_knife_AA
      },
      {
      source: 'other knife',
      target: 'AO',
      value: props.linkdata.other_knife_AO
      },
      {
        source: 'other knife',
        target: 'IC',
        value: props.linkdata.other_knife_IC
      },
      {
        source: 'other knife',
        target: 'JA',
        value: props.linkdata.other_knife_JA
      },
      {
        source: 'vehicle',
        target: 'AA',
        value: props.linkdata.vehicle_AA
      },
      {
        source: 'vehicle',
        target: 'AO',
        value: props.linkdata.vehicle_AO
      },
      {
        source: 'vehicle',
        target: 'IC',
        value: props.linkdata.vehicle_IC
      },
      {
        source: 'bodily force',
        target: 'AA',
        value: props.linkdata.bodily_force_AA
      },
      {
        source: 'bodily force',
        target: 'AO',
        value: props.linkdata.bodily_force_AO
      },
      {
        source: 'bodily force',
        target: 'IC',
        value: props.linkdata.bodily_force_IC
      },
      {
        source: 'bodily force',
        target: 'JA',
        value: props.linkdata.bodily_force_JA
      },
      {
        source: 'bodily force',
        target: 'JO',
        value: props.linkdata.bodily_force_JO
      },
      {
        source: 'unknown weapon',
        target: 'AA',
        value: props.linkdata.unknown_weapon_AA
      },
      {
        source: 'unknown weapon',
        target: 'AO',
        value: props.linkdata.unknown_weapon_AO
      },
      {
        source: 'unknown weapon',
        target: 'IC',
        value: props.linkdata.unknown_weapon_IC
      },
      {
        source: 'unknown weapon',
        target: 'JA',
        value: props.linkdata.unknown_weapon_JA
      },
      {
        source: 'unknown weapon',
        target: 'JO',
        value: props.linkdata.unknown_weapon_JO
      },
      {
        source: 'verbal threat',
        target: 'AA',
        value: props.linkdata.verbal_threat_AA
      },
      {
        source: 'verbal threat',
        target: 'AO',
        value: props.linkdata.verbal_threat_AO
      },
      {
        source: 'verbal threat',
        target: 'IC',
        value: props.linkdata.verbal_threat_IC
      },
      {
        source: 'verbal threat',
        target: 'JA',
        value: props.linkdata.verbal_threat_JA
      },
      {
        source: 'verbal threat',
        target: 'JO',
        value: props.linkdata.verbal_threat_JO
      },
      {
        source: 'mace/pepper spray',
        target: 'AA',
        value: props.linkdata.mace_pepper_spray_AA
      },
      {
        source: 'mace/pepper spray',
        target: 'AO',
        value: props.linkdata.mace_pepper_spray_AO
      },
      {
        source: 'mace/pepper spray',
        target: 'IC',
        value: props.linkdata.mace_pepper_spray_IC
      },
      {
        source: 'mace/pepper spray',
        target: 'JA',
        value: props.linkdata.mace_pepper_spray_JA
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

.chart {
height: 20vw ;
}
</style>