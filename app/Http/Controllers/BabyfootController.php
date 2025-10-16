<?php

namespace App\Http\Controllers;

use App\Models\Babyfoot;
use Illuminate\Http\Request;

class BabyfootController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $babyfoots = Babyfoot::with(['matches.goal', 'matches.equipe1', 'matches.equipe2'])->get();
        return response()->json($babyfoots, 200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
{
    $validated = $request->validate([
        'etat' => 'required|string|max:255',
        'is_used' => 'boolean',
    ]);

    try {
        $babyfoot = Babyfoot::create([
            'etat' => $validated['etat'],
            'is_used' => $validated['is_used'] ?? false,
        ]);

        return response()->json($babyfoot, 201);
    } catch (\Exception $e) {
        return response()->json(['error' => 'Impossible de créer le babyfoot'], 500);
    }
}

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Babyfoot  $babyfoot
     * @return \Illuminate\Http\Response
     */
    public function show(Babyfoot $babyfoot)
    {
         $babyfoot->load(['matches.goal', 'matches.equipe1', 'matches.equipe2']);
        return response()->json($babyfoot, 200);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Babyfoot  $babyfoot
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Babyfoot $babyfoot)
{
    $validated = $request->validate([
        'etat' => 'sometimes|string|max:255',
        'is_used' => 'sometimes|boolean',
    ]);

    try {
        $babyfoot->update($validated);
        return response()->json($babyfoot, 200);
    } catch (\Exception $e) {
        return response()->json(['error' => 'Impossible de mettre à jour le babyfoot'], 500);
    }
}

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Babyfoot  $babyfoot
     * @return \Illuminate\Http\Response
     */
    public function destroy(Babyfoot $babyfoot)
    {
        try {
            $babyfoot->delete();
            return response()->json(null, 204);
        } catch (\Exception $e) {
            return response()->json(['error' => 'Impossible de supprimer le babyfoot'], 500);
        }
    }
}
