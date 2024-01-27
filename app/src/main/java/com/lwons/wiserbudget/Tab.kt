package com.lwons.wiserbudget

val TAB_DETAIL = Tab(0, "Detail", R.drawable.analytics_thick)
val TAB_GRAPH = Tab(1, "Graph", R.drawable.monitoring_thick)
val TAB_DISCOVER = Tab(2, "Discover", R.drawable.explore_thick)
val TAB_SETTINGS = Tab(3, "Settings", R.drawable.settings_thick)

data class Tab(val id: Int, val title: String, val icon: Int)

val tabs = arrayListOf(TAB_DETAIL, TAB_GRAPH, TAB_DISCOVER, TAB_SETTINGS)