<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Matches extends Model
{
    use HasFactory;

    protected $table = 'match';

    protected $fillable = [
        'score_1',
        'score_2',
        'id_equipe_1',
        'id_equipe_2',
        'vitesse_max'
    ];

   // Un match appartient à une équipe 1
    public function equipe1()
    {
        return $this->belongsTo(Team::class, 'id_equipe_1');
    }

    // Un match appartient à une équipe 2
    public function equipe2()
    {
        return $this->belongsTo(Team::class, 'id_equipe_2');
    }

    // Un match peut avoir plusieurs buts.
    public function goals()
    {
        return $this->hasMany(Goal::class, 'id_match');
    }
}
