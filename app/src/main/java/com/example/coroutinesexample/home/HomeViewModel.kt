package com.example.coroutinesexample.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutinesexample.R

class HomeViewModel : ViewModel() {

    private val _items =
        MutableLiveData<MutableList<HomeItemModel>>().apply { value = mutableListOf() }
    val items: LiveData<MutableList<HomeItemModel>>
        get() = _items

    init {
        val temp = mutableListOf<HomeItemModel>()
        //закомменчиваю законченные блоки чтоб не мешались. потом верну

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleDispatchers))
//        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase1, R.id.toDispatchersOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase2, R.id.toDispatchersTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase3, R.id.toDispatchersThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase4, R.id.toDispatchersFour))
//        temp.add(HomeItemModel.HomeItemItem(R.string.dispatchersCase5, R.id.toDispatchersFive))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleErrors)) //ne gotovo
//        temp.add(HomeItemModel.HomeItemItem(R.string.errorsCase1, R.id.toErrorsOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.errorsCase2, R.id.toErrorsTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.errorsCase3, R.id.toErrorsThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.errorsCase4, R.id.toErrorsFour))
//        temp.add(HomeItemModel.HomeItemItem(R.string.errorsCase5, R.id.toErrorsFive))
//        temp.add(HomeItemModel.HomeItemItem(R.string.errorsCase6, R.id.toErrorsSix))
//        temp.add(HomeItemModel.HomeItemItem(R.string.errorsCase7, R.id.toErrorsSeven))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleBuilders))
//        temp.add(HomeItemModel.HomeItemItem(R.string.buildersCase1, R.id.toBuildersOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.buildersCase2, R.id.toBuildersTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.buildersCase3, R.id.toBuildersThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.buildersCase4, R.id.toBuildersFour))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleSuspend))
//        temp.add(HomeItemModel.HomeItemItem(R.string.suspendCase1, R.id.toSuspendOne))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleCoroutines)) //ne gotovo
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase1, R.id.toCoroutinesOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase2, R.id.toCoroutinesTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase3, R.id.toCoroutinesThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase4, R.id.toCoroutinesFour))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase5, R.id.toCoroutinesFive))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase6, R.id.toCoroutinesSix))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase7, R.id.toCoroutinesSeven))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase8, R.id.toCoroutinesEight))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase9, R.id.toCoroutinesNine))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase10, R.id.toCoroutinesTen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase11, R.id.toCoroutinesEleven))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase12, R.id.toCoroutinesTwelve))
//        temp.add(HomeItemModel.HomeItemItem(R.string.coroutinesCase13, R.id.toCoroutinesThirteen))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleScope))
//        temp.add(HomeItemModel.HomeItemItem(R.string.scopeCase1, R.id.toScopeOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.scopeCase2, R.id.toScopeTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.scopeCase3, R.id.toScopeThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.scopeCase4, R.id.toScopeFour))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleScopeFunctions)) //ne gotovo
//        temp.add(HomeItemModel.HomeItemItem(R.string.scopeFunctionsCase1, R.id.toScopeFunctionsOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.scopeFunctionsCase2, R.id.toScopeFunctionsTwo))
//        temp.add(
//            HomeItemModel.HomeItemItem(
//                R.string.scopeFunctionsCase3,
//                R.id.toScopeFunctionsThree
//            )
//        )
//        temp.add(
//            HomeItemModel.HomeItemItem(
//                R.string.scopeFunctionsCase4,
//                R.id.toScopeFunctionsFour
//            )
//        )
//        temp.add(
//            HomeItemModel.HomeItemItem(
//                R.string.scopeFunctionsCase5,
//                R.id.toScopeFunctionsFive
//            )
//        )
//        temp.add(HomeItemModel.HomeItemItem(R.string.scopeFunctionsCase6, R.id.toScopeFunctionsSix))
//        temp.add(
//            HomeItemModel.HomeItemItem(
//                R.string.scopeFunctionsCase7,
//                R.id.toScopeFunctionsSeven
//            )
//        )
//        temp.add(
//            HomeItemModel.HomeItemItem(
//                R.string.scopeFunctionsCase8,
//                R.id.toScopeFunctionsEight
//            )
//        )

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleChannels)) //ne gotovo
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase1, R.id.toChannelsOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase2, R.id.toChannelsTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase3, R.id.toChannelsThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase4, R.id.toChannelsFour))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase5, R.id.toChannelsFive))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase6, R.id.toChannelsSix))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase7, R.id.toChannelsSeven))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase8, R.id.toChannelsEight))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase9, R.id.toChannelsNine))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase10, R.id.toChannelsTen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase11, R.id.toChannelsEleven))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase12, R.id.toChannelsTwelve))
//        temp.add(HomeItemModel.HomeItemItem(R.string.channelsCase13, R.id.toChannelsThirteen))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleFlow))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase1, R.id.toFlowOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase2, R.id.toFlowTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase3, R.id.toFlowThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase4, R.id.toFlowFour))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase5, R.id.toFlowFive))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase6, R.id.toFlowSix))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase7, R.id.toFlowSeven))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase8, R.id.toFlowEight))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase9, R.id.toFlowNine))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase10, R.id.toFlowTen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase11, R.id.toFlowEleven))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase12, R.id.toFlowTwelve))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase13, R.id.toFlowThirteen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase14, R.id.toFlowFourteen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase15, R.id.toFlowFifteen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase16, R.id.toFlowSixteen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase17, R.id.toFlowSeventeen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase18, R.id.toFlowEighteen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase19, R.id.toFlowNineteen))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase20, R.id.toFlowTwenty))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase21, R.id.toFlowTwentyOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase22, R.id.toFlowTwentyTwo))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase23, R.id.toFlowTwentyThree))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase24, R.id.toFlowTwentyFour))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase25, R.id.toFlowTwentyFive))
//        temp.add(HomeItemModel.HomeItemItem(R.string.flowCase26, R.id.toFlowTwentySix))

//        temp.add(HomeItemModel.HomeTitleItem(R.string.titleOperators))
//        temp.add(HomeItemModel.HomeItemItem(R.string.operatorsCase1, R.id.toOperatorsOne))
//        temp.add(HomeItemModel.HomeItemItem(R.string.operatorsCase2, R.id.toOperatorsTwo))

        _items.value = temp
    }
}