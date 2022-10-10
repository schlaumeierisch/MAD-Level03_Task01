package nl.hva.task01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nl.hva.task01.databinding.FragmentSummaryBinding

const val ARG_GAME_NAME = "arg_game_name"
const val ARG_GAME_RATING = "arg_game_rating"

class SummaryFragment : Fragment() {

    private var _binding: FragmentSummaryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gameName = arguments?.getString(ARG_GAME_NAME)
        val gameRating = arguments?.getFloat(ARG_GAME_RATING)

        binding.tvSummary.text = String.format("You rated %s with %.1f stars! Thanks!", gameName, gameRating)

        binding.btnStartOver.setOnClickListener {
            findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}